package com.example.simplecrm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplecrm.model.UserRole;
import com.example.simplecrm.service.UserRoleService;

@RestController
@RequestMapping("/userroles")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    // Create
    @PostMapping("")
    public ResponseEntity<UserRole> createUserRole(@Valid @RequestBody UserRole userRole) {

        UserRole newUserRole = userRoleService.createUserRole(userRole);
        return new ResponseEntity<UserRole>(newUserRole, HttpStatus.CREATED);

    }

    // Get All Users
    @GetMapping("")
    public ResponseEntity<List<UserRole>> getAllUserRoles() {
        List<UserRole> allUserRoles = userRoleService.getAllUserRoles();
        return new ResponseEntity<>(allUserRoles, HttpStatus.OK);

    }

    // Get User
    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getUserRole(@PathVariable int id) {
        UserRole foundUserRole = userRoleService.getUserRole(id);
        return new ResponseEntity<>(foundUserRole, HttpStatus.OK);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<UserRole> updateUserRole(@PathVariable int id, @RequestBody UserRole userRole) {
        UserRole updatedUserRole = userRoleService.updateUserRole(id, userRole);
        return new ResponseEntity<>(updatedUserRole, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUserRole(@PathVariable int id) {
        userRoleService.deleteUserRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}