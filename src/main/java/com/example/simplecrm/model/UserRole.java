package com.example.simplecrm.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;



@Entity
@Table(name = "user_roles")
public class UserRole {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @OneToOne(optional = false)
  @JoinColumn(name = "employee_id", referencedColumnName = "id")
  private Employee idEmployee;

  @Column(name = "role_name")
  @Enumerated(EnumType.STRING)
  private Roles roleName;

  
  // @OneToOne(optional = true)
  // @JoinColumn(name = "employee_department", referencedColumnName = "department")
  // private Employee departmentEmployee;
  @Column(name = " department")
  private Enum userRoleDepartment;

  public UserRole() {
  }

  public UserRole(int id, Roles roleName) {
    this.id = id;
    //this.uid = uid;
    this.roleName = roleName;
    //this.department = department;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  // public int getUid() {
  //   return uid;
  // }

  // public void setUid(int uid) {
  //   this.uid = uid;
  // }

  public Roles getRoleName() {
    return roleName;
  }

  public void setRoleName(Roles roleName) {
    this.roleName = roleName;
  }

  // public String getDepartment() {
  //   return department;
  // }

  // public void setDepartment(String department) {
  //   this.department = department;
  // }

  

  

  @Override
  public String toString() {
    return "UserRole{" +
        "id=" + id +
        ", roleName='" + roleName +
        '}';
  }





public Employee getEmployee(){
  return this.idEmployee;
}


public void setEmployee(Employee idEmployee){
  this.idEmployee = idEmployee;
}

public Enum getUserRoleDepartment() {
  return userRoleDepartment;
}

public void setUserRoleDepartment(Enum userRoledepartment) {
  this.userRoleDepartment = userRoledepartment;
}





}