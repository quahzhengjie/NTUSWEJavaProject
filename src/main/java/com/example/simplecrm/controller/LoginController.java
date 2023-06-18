package com.example.simplecrm.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplecrm.exception.InvalidUsernameOrPasswordException;
import com.example.simplecrm.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("")
    public ResponseEntity<Boolean> login(@Valid @RequestBody String username, String password,
            HttpServletResponse response) {
        try {
            int employeeId = loginService.login(username, password);

            Cookie cookie = new Cookie("username", Integer.toString(employeeId));
            // add cookie in server response
            response.addCookie(cookie);

            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (InvalidUsernameOrPasswordException error) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}