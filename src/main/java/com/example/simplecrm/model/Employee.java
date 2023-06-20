package com.example.simplecrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  // Join to loginid
  @OneToOne
  @JoinColumn(name = "login_id")
  private Login login;

  @Column(name = "first_name")
  @NotBlank(message = "First name is mandatory.")
  @Size(min = 2, max = 15, message = "First name must be between 2 and 15 characters.")
  private String firstName;

  @Column(name = "last_name")
  @NotBlank(message = "Last name is mandatory.")
  @Size(min = 2, max = 15, message = "Last name must be between 2 and 15 characters.")
  private String lastName;

  @Column(name = "email")
  @Email(message = "Email must be valid.")
  @NotBlank(message = "Email is mandatory.")
  private String email;

  @Column(name = "contact")
  private String contact;

  @Column(name = "department")
  @Enumerated(EnumType.STRING)
  private Department department;

  // @Column(name = "department")
  // private String department;

  public Employee() {
  }

  public Employee(int id, String firstName, String lastName, String email, String contact, Department department) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.contact = contact;
    this.department = department;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Login getLogin() {
    return login;
  }

  public void setLogin(Login login) {
    this.login = login;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  // @Override
  // public String toString() {
  // return "User{" +
  // "id=" + id +
  // ", firstName='" + firstName + '\'' +
  // ", lastName='" + lastName + '\'' +
  // ", email='" + email + '\'' +
  // ", department='" + department + '\'' +
  // ", contact='" + contact + '\'' +
  // '}';
  // }
}
