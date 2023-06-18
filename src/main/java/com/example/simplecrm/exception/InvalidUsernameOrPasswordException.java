package com.example.simplecrm.exception;

public class InvalidUsernameOrPasswordException extends RuntimeException {
  public InvalidUsernameOrPasswordException() {
    super("Invalid Username/Password");
  }
}
