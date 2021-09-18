package com.omar.demo.controller;

import com.omar.demo.data.AnimeResourceProxy;
import com.omar.demo.data.StudioResourceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Controller
public class HomeController {
  private static final String VIEW = "home";

  @Autowired
  AnimeResourceProxy animeResourceProxy;

  @Autowired
  StudioResourceProxy studioResourceProxy;

  @Async
  @GetMapping({"/home", "/"})
  public CompletableFuture<String> getHome() {
    return CompletableFuture.completedFuture(VIEW);
  }

}
