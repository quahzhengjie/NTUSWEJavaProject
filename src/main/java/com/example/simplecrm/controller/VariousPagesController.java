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
}