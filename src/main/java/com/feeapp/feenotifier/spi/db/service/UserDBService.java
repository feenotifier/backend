package com.feeapp.feenotifier.spi.db.service;

import com.feeapp.feenotifier.domain.User.User;
import com.feeapp.feenotifier.domain.User.UserList;
import com.feeapp.feenotifier.domain.User.login.LoginCredentials;
import com.feeapp.feenotifier.domain.User.signup.SignupResponse;

public interface UserDBService {

    SignupResponse addUser(User user);

    UserList getUsers();

    User findUser(LoginCredentials loginCredentials);

}
