package com.example.simplecrm.service;

import com.example.simplecrm.model.Department;
import com.example.simplecrm.model.Employee;
import com.example.simplecrm.model.Login;
import com.example.simplecrm.repository.LoginRepository;
import com.example.simplecrm.service.UserRoleService;
import com.example.simplecrm.model.UserRole;
import com.example.simplecrm.model.Roles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// some code
public class LoginServiceImpl implements LoginService {

  private final LoginRepository loginRepository;
  private final EmployeeService employeeService;
  private final UserRoleService userRoleService; // UserRoleService injected

  @Autowired
  public LoginServiceImpl(LoginRepository loginRepository, EmployeeService employeeService,
      UserRoleService userRoleService) { // UserRoleService included in constructor
    this.loginRepository = loginRepository;
    this.employeeService = employeeService;
    this.userRoleService = userRoleService; // Initialize UserRoleService
  }

  @Override
  public boolean authenticate(String loginId, String password) {
    Login login = loginRepository.findByLoginId(loginId);
    return login != null && login.getPassword().equals(password);
  }

  @Override
  public boolean createUser(Login login) {
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

    // After saving the Login, create an Employee
    Employee employee = new Employee();
    employee.setLogin(login); // Assuming the 'login' field in Employee is a foreign key to the Login

    // Set the other fields of Employee as necessary. You can modify these values
    // according to your requirements
    employee.setFirstName("default");
    employee.setLastName("default");
    employee.setEmail("default@example.com");
    employee.setContact("default");
    employee.setDepartment(Department.DEFAULT);

    try {
      // Assuming createEmployee saves the created Employee to a database or some form
      // of storage.
      // If not, modify this line accordingly
      employeeService.createEmployee(employee);

      // After creating an Employee, create a UserRole
      UserRole userRole = new UserRole();
      userRole.setEmployee(employee); // Link the user role to the new employee
      userRole.setRoleName(Roles.Employee); // Set a default role
      userRole.setUserRoleDepartment(Department.DEFAULT);
      ; // Set a default role

      // Save the UserRole to the database using the userRoleService
      userRoleService.createUserRole(userRole);

    } catch (Exception e) {
      // Log the error and return false if there was a problem creating the Employee
      // or UserRole
      return false;
    }

    // If everything went well, return true
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
