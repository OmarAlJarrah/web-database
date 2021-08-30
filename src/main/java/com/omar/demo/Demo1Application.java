package com.omar.demo;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;


@SpringBootApplication
public class Demo1Application {
  public static void main(String[] args) {
    SpringApplication.run(Demo1Application.class, args);
  }

}
