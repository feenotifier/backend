package com.feeapp.feenotifier.spi.db.mapper;

import com.feeapp.feenotifier.domain.User.User;
import com.feeapp.feenotifier.spi.db.entity.UserEntity;

public class EntityToUserMapper {
    public static User map(UserEntity userEntity) {
        User user = new User();
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setEmail(userEntity.getEmail());
        user.setPhoneNumber(userEntity.getPhoneNumber());
        user.setPassword(userEntity.getPassword());
        user.setUserPermission("BASIC");
        return user;
    }
}
