package com.omar.demo.controller;


import com.omar.demo.service.AdminService;
import com.omar.demo.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

  @Autowired
  AdminService service;

  @Autowired
  ValidateService validateService;

  @GetMapping("/admin")
  public ModelAndView getAdminView() {
    ModelAndView model = new ModelAndView("admin");
    model.addObject("formView", "admin-form.jsp");
    return model;
  }

  @PostMapping("/admin")
  public String addUser(@RequestParam("id") String id,
                        @RequestParam("password") String password,
                        @RequestParam("userType") String userType,
                        ModelMap model) {
    if (!validateService.validatePassword(password)
                        || !service.addUser(Long.parseLong(id), password, userType)) {
      model.addAttribute("errorMessage", "Invalid data!");
    }
    model.addAttribute("formView", "admin-form.jsp");
    return "admin";
  }
}
