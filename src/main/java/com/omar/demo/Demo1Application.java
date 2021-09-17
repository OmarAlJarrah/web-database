package com.omar.demo;

import com.omar.demo.data.AnimeResourceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
@EnableCaching
public class Demo1Application {

  public static void main(String[] args) {
    SpringApplication.run(Demo1Application.class, args);
  }

}
