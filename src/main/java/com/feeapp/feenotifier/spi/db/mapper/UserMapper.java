package com.feeapp.feenotifier.spi.db.mapper;

import com.feeapp.feenotifier.domain.User.User;
import com.feeapp.feenotifier.spi.db.entity.UserEntity;

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
