package com.feeapp.feenotifier.domain.User.signup;

import lombok.Data;

import java.util.UUID;

@Data
public class SignupResponse {
    private Boolean isCreated;
    private UUID userId;
    private String email;
    private String response;
}
