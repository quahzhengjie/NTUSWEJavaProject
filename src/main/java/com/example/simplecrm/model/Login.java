package com.example.simplecrm.model;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "loginid")
  private String loginId;

  @Column(name = "password")
  private String password;

  public Login() {
  }

  public Login(String loginId, String password) {
    this.loginId = loginId;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLoginId() {
    return loginId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
