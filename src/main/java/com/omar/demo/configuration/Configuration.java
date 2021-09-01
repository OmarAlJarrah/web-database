package com.omar.demo.configuration;

import com.omar.demo.data.AnimeResourceProxy;
import com.omar.demo.data.Resource;
import com.omar.demo.data.StudioResourceProxy;
import com.omar.demo.objects.Anime;
import com.omar.demo.objects.Studio;
import com.omar.demo.serialization.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Objects;

@Component
public class Configuration {
  @Autowired
  AnimeResourceProxy animeProxy;

  @Autowired
  StudioResourceProxy studioProxy;

  @PostConstruct
  private void config() {
    File currentDirectory = new File("./");
    loadData(currentDirectory, Anime.class.getName(), animeProxy);
    loadData(currentDirectory, Studio.class.getName(), studioProxy);
  }

  private void loadData(@org.jetbrains.annotations.NotNull File directory, String key, Resource resource) {
    for (File file : Objects.requireNonNull(directory.listFiles())) {
      String reference = file.getName();
      if (reference.contains(key)) {
        long id = Reference.parseId(reference);
        resource.add(id, reference);
      }
    }
  }
}
