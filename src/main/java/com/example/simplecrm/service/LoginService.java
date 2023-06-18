package com.example.simplecrm.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    void createLoginRecord(int employeeId);

    int login(String username, String password);
}