package com.example.simplecrm.service;

import java.util.List;

import com.example.simplecrm.model.UserRole;


public interface UserRoleService{

    UserRole createUserRole(UserRole userRole);

    UserRole getUserRole(int id);

    List<UserRole> getAllUserRoles();

    UserRole updateUserRole(int id, UserRole userRole);

    void deleteUserRole(int id);



}