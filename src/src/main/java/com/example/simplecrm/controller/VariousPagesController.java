package com.example.simplecrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VariousPagesController {

  @GetMapping("/")
  public String home() {
    return "home"; // Return the name of your front-end page (without the extension)
  }

  @GetMapping("/about")
  public String about() {
    return "about"; // Return the name of your front-end page (without the extension)
  }

  @GetMapping("/application")
  public String application() {
    return "application"; // Return the name of your front-end page (without the extension)
  }

  @GetMapping("/dashboard")
  public String dashboard() {
    return "dashboard"; // Return the name of your front-end page (without the extension)
  }

  @GetMapping("/login")
  public String login() {
    return "login"; // Return the name of your front-end page (without the extension)
  }

  @GetMapping("/registeremployee")
  public String register() {
    return "register"; // Return the name of your front-end page (without the extension)
  }

  @GetMapping("/createaccount")
  public String crreateaccount() {
    return "createaccount"; // Return the name of your front-end page (without the extension)
  }

  @GetMapping("/approveclaimdetails")
  public String approveexpenseclaimdetails() {
    return "approveexpenseclaimdetails"; // Return the name of your front-end page (without the extension)
  }
}
