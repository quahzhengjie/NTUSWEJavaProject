package com.example.simplecrm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simplecrm.exception.EmployeeNotFoundException;
import com.example.simplecrm.exception.UserRoleNotFoundException;
import com.example.simplecrm.model.Employee;
import com.example.simplecrm.model.UserRole;
import com.example.simplecrm.repository.EmployeeRepository;
import com.example.simplecrm.repository.UserRoleRepository;
//import com.example.simplecrm.model.UserRole;
//import com.example.simplecrm.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    // @Autowired
    private UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;

    }

    // @Autowired
    // private EmployeeRepository employeeRepository;

    // public UserRoleServiceImpl(UserRoleRepository userRepository){
    // this.userRoleRepository = userRepository;
    // }

    // Create
    @Override
    public UserRole createUserRole(UserRole userRole) {
        UserRole newUserRole = userRoleRepository.save(userRole);
        return newUserRole;
    }

    /// Get One
    @Override
    public UserRole getUserRole(int id) {
        Optional<UserRole> foundUserRole = userRoleRepository.findById(id);
        if (!foundUserRole.isPresent()) {
            throw new UserRoleNotFoundException(id);
        }
        return foundUserRole.get();
    }

    // Get All
    @Override
    public List<UserRole> getAllUserRoles() {
        List<UserRole> allUserRoles = userRoleRepository.findAll();
        return allUserRoles;
    }

    // Update
    @Override
    public UserRole updateUserRole(int id, UserRole userRole) {
        Optional<UserRole> wrappedUserRole = userRoleRepository.findById(id);

        if (!wrappedUserRole.isPresent()) {
            throw new UserRoleNotFoundException(id);
        }
        UserRole userRoleToUpdate = wrappedUserRole.get();
        userRoleToUpdate.setRoleName(userRole.getRoleName());
        userRoleToUpdate.setUserRoleDepartment(userRole.getUserRoleDepartment());
        return userRoleRepository.save(userRoleToUpdate);
    }

    // Delete
    @Override
    public void deleteUserRole(int id) {
        userRoleRepository.deleteById(id);
    }

}