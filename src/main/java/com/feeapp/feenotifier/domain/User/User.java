package com.feeapp.feenotifier.domain.User;

import lombok.Data;

@Data
public class User {
    Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String userPermission;
    private String createdAt;
}
