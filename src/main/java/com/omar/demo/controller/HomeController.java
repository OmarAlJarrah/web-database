package com.omar.demo.controller;

import com.omar.demo.authorization.users.AuthorizationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping({"/home", "/"})
  public String getHome() {
    return "home";
  }

}
