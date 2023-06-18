package com.example.simplecrm.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logout")
public class LogoutController {
    @PostMapping("")
    public ResponseEntity<Boolean> logout(@Valid HttpServletResponse response) {
        Cookie cookie = new Cookie("username", null);
        cookie.setMaxAge(0);
        cookie.setSecure(true);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
