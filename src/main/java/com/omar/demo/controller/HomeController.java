package com.omar.demo.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.CompletableFuture;

@Controller
public class HomeController {

  @Async
  @GetMapping({"/home", "/"})
  public CompletableFuture<String> getHome() {
    return CompletableFuture.completedFuture("home");
  }

}
