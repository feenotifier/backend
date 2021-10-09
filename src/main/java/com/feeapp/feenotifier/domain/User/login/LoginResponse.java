package com.feeapp.feenotifier.domain.User.login;

import com.feeapp.feenotifier.spi.enums.UserLoginResponse;
import java.util.UUID;
import lombok.Data;

@Data
public class LoginResponse {
  private Boolean isLogin;
  private UUID userId;
  private UserLoginResponse response;
  private String email;
}
