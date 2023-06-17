package com.example.simplecrm.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    int getUserId(String loginId);

    void setUserId(String loginId);

    Boolean login(String loginId, String password);

    void logout();
}