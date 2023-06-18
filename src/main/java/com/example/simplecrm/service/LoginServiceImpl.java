package com.example.simplecrm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simplecrm.exception.InvalidUsernameOrPasswordException;
import com.example.simplecrm.model.Login;
import com.example.simplecrm.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
    // Field-based injection
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public int login(String username, String password) {
        try {
            if (validateString(password) || validateString(username)) {
                throw new InvalidUsernameOrPasswordException();
            }

            int loginId = Integer.parseInt(username);
            Optional<Login> foundLogin = loginRepository.findById(loginId);
            if (foundLogin.isPresent() && foundLogin.get().getPassword() == password) {
                return foundLogin.get().getLoginId();
            } else {
                throw new InvalidUsernameOrPasswordException();
            }
        } catch (NumberFormatException ex) {
            throw new InvalidUsernameOrPasswordException();
        }
    }

    @Override
    public void createLoginRecord(int employeeId) {
        Login loginRecordToBeCreated = new Login(employeeId, "password", null);
        loginRepository.save(loginRecordToBeCreated);
        return;
    }

    public Boolean validateString(String stringToBeValidated) {
        if (stringToBeValidated == null || stringToBeValidated.isEmpty() || stringToBeValidated.trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}