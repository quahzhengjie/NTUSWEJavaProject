package com.example.simplecrm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simplecrm.model.Employee;
import com.example.simplecrm.model.UserRole;
import com.example.simplecrm.exception.EmployeeNotFoundException;
import com.example.simplecrm.repository.EmployeeRepository;
import com.example.simplecrm.repository.UserRoleRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  // Field-based injection
  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private UserRoleRepository userRoleRepository;

  // Create
  @Override
  public Employee createEmployee(Employee employee) {
    Employee newEmployee = employeeRepository.save(employee);
    return newEmployee;
  }

  // Get One
  @Override
  public Employee getEmployee(int id) {
    Optional<Employee> foundEmployee = employeeRepository.findById(id);

    if (foundEmployee.isPresent()) {
      return foundEmployee.get();
    } else {
      throw new EmployeeNotFoundException(id);
    }
  }

  // Get All
  @Override
  public List<Employee> getAllEmployees() {
    List<Employee> allEmployees = employeeRepository.findAll();
    return allEmployees;
  }

  // Update
  @Override
  public Employee updateEmployee(int id, Employee employee) {
    Optional<Employee> wrappedEmployeeToUpdate = employeeRepository.findById(id);

    // Early return/ Guard clause
    if (!wrappedEmployeeToUpdate.isPresent()) {
      throw new EmployeeNotFoundException(id);
    }

    // Unwrap it
    Employee employeeToUpdate = wrappedEmployeeToUpdate.get();

    // Update the employee retrieved from DB
    employeeToUpdate.setFirstName(employee.getFirstName());
    employeeToUpdate.setLastName(employee.getLastName());
    employeeToUpdate.setEmail(employee.getEmail());
    employeeToUpdate.setDepartment(employee.getDepartment());
    employeeToUpdate.setContact(employee.getContact());

    // Save and return the data
    return employeeRepository.save(employeeToUpdate);
  }

  // Delete
  @Override
  public void deleteEmployee(int id) {
    employeeRepository.deleteById(id);
  }



      //add userRole to employee
    @Override
    public UserRole addUserRoleToEmployee(int id, UserRole userRole){
        //Retrive Employee from Emplyee repo
        Optional<Employee> wrappedSelectedEmployee = employeeRepository.findById(id);
        if(!wrappedSelectedEmployee.isPresent()){
            throw new EmployeeNotFoundException(id);
        }
        Employee selectedEmployee = wrappedSelectedEmployee.get();
        //add department
        userRole.setUserRoleDepartment(selectedEmployee.getDepartment());
        //add employee to userRole
        userRole.setEmployee(selectedEmployee);
        //add userRole to DB
        return userRoleRepository.save(userRole);
    }

}
