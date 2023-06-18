package com.example.simplecrm.model;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "loginid")
  private int loginId;

  @Column(name = "password")
  private String password;

  @Column(name = "jwt_token")
  private String jwtToken;

  public Login() {
  }

  public Login(int loginId, String password, String jwtToken) {
    this.loginId = loginId;
    this.password = password;
    this.jwtToken = jwtToken;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getLoginId() {
    return loginId;
  }

  public void setLoginId(int loginId) {
    this.loginId = loginId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getJwtToken() {
    return jwtToken;
  }

  public void setJwtToken(String jwtToken) {
    this.jwtToken = jwtToken;
  }
}
