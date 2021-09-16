package com.feeapp.feenotifier.db.mapper;

import com.feeapp.feenotifier.db.entity.UserEntity;
import com.feeapp.feenotifier.models.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserMapper {
    public static UserEntity map(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setPassword(encryptPassword(user.getPassword()));
        userEntity.setUserPermission("BASIC");
        return userEntity;
    }

    public static String encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(password.getBytes());

            byte[] resultByteArray = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for (byte b : resultByteArray) {
                sb.append(String.format("%03xx", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }
}

