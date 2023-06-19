package com.example.simplecrm.controller;

import com.example.simplecrm.model.Login;
import com.example.simplecrm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/login")
public class LoginController {

  private final LoginService loginService;

  @Autowired
  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  // POST METHOD to /api/login
  @PostMapping
  public ResponseEntity<String> login(@RequestBody Login login, HttpServletResponse response) {
    boolean isAuthenticated = loginService.authenticate(login.getLoginId(), login.getPassword());
    if (isAuthenticated) {
      // Retrieve the user by loginId
      Login user = loginService.getUserByLoginId(login.getLoginId());

      // Create and set the cookie in the response with the user's primary key as the
      // value
      Cookie cookie = new Cookie("loginCookie", String.valueOf(user.getId()));
      cookie.setMaxAge(24 * 60 * 60); // Set the cookie expiration time in seconds (e.g., 24 hours)
      cookie.setPath("/"); // Set the cookie path to '/' to make it accessible from all paths
      response.addCookie(cookie);

      return ResponseEntity.ok("Login successful");
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
  }

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody Login login) {
    boolean isCreated = loginService.createUser(login);
    if (isCreated) {
      return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user");
    }
  }

  @GetMapping("/users")
  public List<Login> getAllUsers() {
    return loginService.getAllUsers();
  }

}
