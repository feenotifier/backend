package com.feeapp.feenotifier.domain.User;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    Long id;
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String userPermission;
    private String createdAt;
}
