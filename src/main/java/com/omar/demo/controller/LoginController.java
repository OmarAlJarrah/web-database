package com.omar.demo.controller;

import com.omar.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

  @Autowired
  LoginService service;

  @GetMapping("/login")
  public String getLogin() {
    return "login";
  }

  @PostMapping("/login")
  public String postLogin(@RequestParam("id") String id,
                          @RequestParam("password") String password,
                          @RequestParam("userType") String userType,
                          ModelMap model, HttpServletResponse response) {
    if (service.validate(Long.parseLong(id),
            password, userType.equals("admin"))) {
      response.addCookie(new Cookie("authorized", "true"));
      response.addCookie(new Cookie("isAdmin", Boolean.toString(userType.equals("admin"))));
      return "home";
    } else {
      model.addAttribute("errorMessage", "ERROR");
      return "login";
    }
  }

}
