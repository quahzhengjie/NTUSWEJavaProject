package com.example.simplecrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simplecrm.repository.LoginRepository;
import com.example.simplecrm.service.EmployeeService;

@Service
public class LoginServiceImpl implements LoginService {
    // Field-based injection
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public Boolean login(String loginId, String password) {
        // 1. getUserId -> query by loginId
        // 2. getEmployee(id)
        // -> if returned employee not empty, return true
        // -> set employee_id as cookie
        // -> else, return false
        return true;
    }

    @Override
    public int getUserId(String loginId) {
        return 0;
    }

    @Override
    public void setUserId(String loginId) {

    }

    @Override
    public void logout() {
        // remove cookie
    }
}