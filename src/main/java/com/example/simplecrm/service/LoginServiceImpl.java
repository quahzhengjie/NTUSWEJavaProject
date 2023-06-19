package com.example.simplecrm.service;

import com.example.simplecrm.model.Login;
import com.example.simplecrm.repository.LoginRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

  private final LoginRepository loginRepository;

  @Autowired
  public LoginServiceImpl(LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
  }

  @Override
  public boolean authenticate(String loginId, String password) {
    Login login = loginRepository.findByLoginId(loginId);
    return login != null && login.getPassword().equals(password);
  }

  @Override
  public boolean createUser(Login login) {
    // Perform user creation logic
    // You can add validation and other necessary steps

    // Validate the loginId and password
    if (login.getLoginId() == null || login.getLoginId().isEmpty() || login.getPassword() == null
        || login.getPassword().isEmpty()) {
      throw new IllegalArgumentException("LoginId and password are required.");
    }

    // Check if the loginId already exists
    if (loginRepository.existsByLoginId(login.getLoginId())) {
      throw new IllegalArgumentException("LoginId already exists. Please choose a different one.");
    }

    // Save the new user to the database using the loginRepository
    loginRepository.save(login);

    return true;
  }

  @Override
  public List<Login> getAllUsers() {
    return loginRepository.findAll();
  }

  @Override
  public Login getUserByLoginId(String loginId) {
    return loginRepository.findByLoginId(loginId);
  }
}
