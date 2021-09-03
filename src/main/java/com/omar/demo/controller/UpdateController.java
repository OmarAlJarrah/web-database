package com.omar.demo.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.CompletableFuture;

@Controller
public class UpdateController {

  @GetMapping("/update")
  public String getUpdate() {
    return "update";
  }

  @Async
  @PostMapping("/update")
  public CompletableFuture<String> postUpdate(@RequestParam("type") String type,
                                              ModelMap model) {
    String form = (type.equalsIgnoreCase("anime")? "anime-form.jsp" : "studio-form.jsp");
    model.addAttribute("formView", form);
    return CompletableFuture.completedFuture("update");
  }
}
