package com.omar.demo.controller;

import com.omar.demo.data.AnimeResourceProxy;
import com.omar.demo.data.StudioResourceProxy;
import com.omar.demo.objects.Anime;
import com.omar.demo.objects.DataRecord;
import com.omar.demo.objects.Studio;
import com.omar.demo.service.CreateService;
import com.omar.demo.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.CompletableFuture;

@Controller
public class CreateController {
  @Autowired
  CreateService service;

  @Autowired
  AnimeResourceProxy animeResourceProxy;

  @Autowired
  StudioResourceProxy studioResourceProxy;

  @Autowired
  ValidationService validationService;


  @GetMapping("/create")
  public String getCreate()  {
    return "create";
  }

  @Async
  @PostMapping("/create")
  public CompletableFuture<String> postCreate(@RequestParam("operation") String operation, ModelMap model) {
      model.addAttribute("formView", "anime-form.jsp");
    return CompletableFuture.completedFuture("create");
  }

  @Async
  @PostMapping("/create-anime")
  public CompletableFuture<String> postCreateRecord(@RequestParam("name") String name,
                                                    @RequestParam("id") String id,
                                                    @RequestParam("year") String year,
                                                    @RequestParam("studio_id") String studioId,
                                                    @RequestParam("watch_count") String watchCount,
                                                    @RequestParam("rating") String rating,
                                                    ModelMap model) {
    DataRecord dataRecord = (DataRecord) (new Anime.Builder()
            .setId(Long.parseLong(id))
            .setName(name)
            .setRating(Integer.parseInt(rating))
            .setWatchCount(Integer.parseInt(watchCount))
            .setYearOfProduction(Integer.parseInt(year))
            .setCreatorId(Integer.parseInt(studioId))
            .create());

    if (validationService.validateCreate(dataRecord, animeResourceProxy)) {
      service.create(dataRecord, animeResourceProxy);
    } else {
      model.addAttribute("errorMessage", "Invalid data!");
    }
    return CompletableFuture.completedFuture("create");
  }

  @Async
  @PostMapping("/create-studio")
  public CompletableFuture<String> postCreateStudio(@RequestParam("name") String name,
                                                    @RequestParam("id") String id,
                                                    @RequestParam("year") String year,
                                                    @RequestParam("location") String location,
                                                    ModelMap model) {

    DataRecord dataRecord = (DataRecord) new Studio.Builder()
            .setId(Long.parseLong(id))
            .setName(name)
            .setLocation(location)
            .setStartYear(Long.parseLong(year))
            .build();

    if (validationService.validateCreate(dataRecord, studioResourceProxy)) {
      service.create(dataRecord, studioResourceProxy);
    } else {
      model.addAttribute("errorMessage", "Invalid data!");
    }
    return CompletableFuture.completedFuture("create");
  }
}
