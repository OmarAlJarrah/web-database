package com.omar.demo.controller;

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

  @GetMapping("/create")
  public String getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    return "create";
  }

  @PostMapping("/create")
  public String postCreate(@RequestParam("operation") String operation, ModelMap model) {
      model.addAttribute("formView", "anime-form.jsp");
    return "create";
  }

  @PostMapping("/create-record")
  public String postCreateRecord(@RequestParam("name") String name,
                                 @RequestParam("id") String id){
    System.out.println(name);
    System.out.println(id);
    return "create";
  }
}
