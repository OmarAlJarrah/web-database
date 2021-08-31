package com.omar.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UpdateController {

  @GetMapping("/update")
  public String getUpdate() {
    return "update";
  }
  // TODO: Post method
}
