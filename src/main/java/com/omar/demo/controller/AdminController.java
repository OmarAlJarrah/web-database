package com.omar.demo.controller;


import com.omar.demo.service.AdminService;
import com.omar.demo.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings({"ALL", "SpringJavaAutowiredFieldsWarningInspection"})
@Controller
public class AdminController {
  private static final String VIEW = "admin";

  @Autowired
  AdminService service;

  @Autowired
  ValidationService validationService;

  @Async
  @GetMapping("/admin")
  public CompletableFuture<ModelAndView> getAdminView() {
    ModelAndView model = new ModelAndView(VIEW);
    model.addObject("formView", "admin-form.jsp");
    return CompletableFuture.completedFuture(model);
  }

  @Async
  @PostMapping("/admin")
  public CompletableFuture<String> addUser(@RequestParam("id") String id,
                                           @RequestParam("password") String password,
                                           @RequestParam("userType") String userType,
                                           ModelMap model) {
    if (!validationService.validatePassword(password)
                        || !service.addUser(Long.parseLong(id), password, userType)) {
      model.addAttribute("errorMessage", "Invalid data!");
    } else {
      service.addUser(Long.parseLong(id), password, userType);
    }
    model.addAttribute("formView", "admin-form.jsp");
    return CompletableFuture.completedFuture(VIEW);
  }
}
