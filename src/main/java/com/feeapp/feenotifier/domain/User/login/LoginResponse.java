package com.feeapp.feenotifier.domain.User.login;

import lombok.Data;

@Data
public class LoginResponse {
    private Boolean isLogin;
    private String response;
    private String email;
}
