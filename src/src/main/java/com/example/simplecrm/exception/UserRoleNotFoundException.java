package com.example.simplecrm.exception;

public class UserRoleNotFoundException extends RuntimeException {

     public UserRoleNotFoundException(int id) {
      super("UserRole id " + id + " not found.");
    }
}

