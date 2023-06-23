package com.example.simplecrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VariousPagesController {

  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/about")
  public String about() {
    return "about";
  }

  @GetMapping("/application")
  public String application() {
    return "application";
  }

  @GetMapping("/dashboard")
  public String dashboard() {
    return "dashboard"; 
  }

  @GetMapping("/login")
  public String login() {
    return "login"; 
  }

  @GetMapping("/registeremployee")
  public String register() {
    return "register"; 
  }

  @GetMapping("/createaccount")
  public String crreateaccount() {
    return "createaccount"; 
  }

  @GetMapping("/approveclaimdetails")
  public String approveexpenseclaimdetails() {
    return "approveexpenseclaimdetails"; 
// Return the name of your front-end page saved in resources
  }
}
