package com.feeapp.feenotifier.domain.User.signup;

import com.feeapp.feenotifier.spi.enums.UserSignUpResponse;
import java.util.UUID;
import lombok.Data;

@Data
public class SignupResponse {
  private Boolean isCreated;
  private UUID userId;
  private String email;
  private UserSignUpResponse response;
}
