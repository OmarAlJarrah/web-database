package com.omar.demo;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class Demo1Application {
  final Tomcat tomcat = new Tomcat();

  @PostConstruct
  void init() {
    tomcat.setPort(8080);
    tomcat.addUser("admin", "admin");
    tomcat.addRole("admin", "admin");
//    tomcat.init();
  }

  public static void main(String[] args) {

    SpringApplication.run(Demo1Application.class, args);
  }

}
