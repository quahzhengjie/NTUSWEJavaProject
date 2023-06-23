package com.example.simplecrm.service;

import java.util.List;

import com.example.simplecrm.model.Login;

public interface LoginService {
  boolean authenticate(String loginId, String password);

  boolean createUser(Login login);

  List<Login> getAllUsers();

  Login getUserByLoginId(String loginId);

}
