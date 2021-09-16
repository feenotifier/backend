package com.feeapp.feenotifier.db.mapper;

import com.feeapp.feenotifier.db.entity.UserEntity;
import com.feeapp.feenotifier.models.User;

public class UserMapper {
    public static UserEntity map(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setPassword(user.getPassword());
        userEntity.setUserPermission("BASIC");
        return userEntity;
    }
}
