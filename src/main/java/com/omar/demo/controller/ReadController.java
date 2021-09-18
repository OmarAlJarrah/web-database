package com.omar.demo.controller;

import com.omar.demo.data.AnimeResourceProxy;
import com.omar.demo.data.Proxy;
import com.omar.demo.data.StudioResourceProxy;
import com.omar.demo.service.ReadService;
import com.omar.demo.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Controller
public class ReadController {
  private static final String VIEW = "read";

  @Autowired
  ReadService service;

  @Autowired
  ValidationService validationService;

  @Autowired
  AnimeResourceProxy animeResourceProxy;

  @Autowired
  StudioResourceProxy studioResourceProxy;

  @GetMapping("/read")
  public String getRead() {
    return VIEW;
  }

  @Async
  @PostMapping("read")
  public CompletableFuture<ModelAndView> read(@RequestParam("id") String id, @RequestParam("type") String type) {
    ModelAndView model = new ModelAndView(VIEW);
    Proxy proxy = (type.equalsIgnoreCase("anime")? animeResourceProxy : studioResourceProxy);
    if (validationService.validateDataRecordId(Long.parseLong(id), proxy)) {
      model.addObject(type, service.read(Long.parseLong(id), proxy));
    } else {
      model.addObject("errorMessage", "Invalid id");
    }

    return CompletableFuture.completedFuture(model);
  }

  @Async
  @PostMapping("/readAll")
  public CompletableFuture<ModelAndView> readAll(@RequestParam("type") String type) {
    ModelAndView model = new ModelAndView(VIEW);
    Proxy proxy = (type.equalsIgnoreCase("anime")? animeResourceProxy : studioResourceProxy);
    model.addObject(type, service.readAll(proxy));
    return CompletableFuture.completedFuture(model);
  }
}
