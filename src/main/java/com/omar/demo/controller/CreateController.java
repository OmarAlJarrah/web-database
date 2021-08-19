package com.omar.demo.controller;

import com.omar.demo.data.AnimeResource;
import com.omar.demo.data.StudioReference;
import com.omar.demo.objects.Anime;
import com.omar.demo.objects.DataRecord;
import com.omar.demo.objects.Studio;
import com.omar.demo.service.CreateService;
import com.omar.demo.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CreateController {
  @Autowired
  CreateService service;

  @Autowired
  AnimeResource animeResource;

  @Autowired
  StudioReference studioResource;

  @Autowired
  ValidateService validateService;

  @GetMapping("/create")
  public String getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    return "create";
  }

  @PostMapping("/create")
  public String postCreate(@RequestParam("operation") String operation, ModelMap model) {
      model.addAttribute("formView", "anime-form.jsp");
    return "create";
  }


  @PostMapping("/create-anime")
  public String postCreateRecord(@RequestParam("name") String name,
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
    if (validateService.validateCreate(dataRecord, animeResource)) {
      service.create(dataRecord, animeResource);
    } else {
      model.addAttribute("errorMessage", "Invalid data!");
    }
    return "create";
  }
}
