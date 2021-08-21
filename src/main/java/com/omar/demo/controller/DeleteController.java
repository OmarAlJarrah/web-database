package com.omar.demo.controller;

import com.omar.demo.data.AnimeResource;
import com.omar.demo.data.Resource;
import com.omar.demo.data.StudioResource;
import com.omar.demo.service.DeleteService;
import com.omar.demo.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {

  @Autowired
  AnimeResource animeResource;

  @Autowired
  StudioResource studioResource;

  @Autowired
  DeleteService service;

  @Autowired
  ValidateService validateService;

  @GetMapping("/delete")
  public String getDelete() {
    return "delete";
  }

  @PostMapping("/delete")
  public String postDelete(@RequestParam("id") String id,
                           @RequestParam("type") String type,
                           ModelMap model) {

    Resource resource = (type.equals("anime")? animeResource : studioResource);

    if (validateService.validateId(Long.parseLong(id), resource)) {
      service.delete(Long.parseLong(id), animeResource);
    } else {
      model.addAttribute("errorMessage", "Invalid Id");
    }
    return "delete";
  }

}
