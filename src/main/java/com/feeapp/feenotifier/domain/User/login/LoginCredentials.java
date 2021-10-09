package com.feeapp.feenotifier.domain.User.login;

import lombok.Data;

@Data
public class LoginCredentials {
  private String email;
  private String password;

  public LoginCredentials(String email, String password) {
    this.email = email;
    this.password = password;
  }
}
