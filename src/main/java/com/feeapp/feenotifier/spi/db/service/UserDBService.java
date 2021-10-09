package com.feeapp.feenotifier.spi.db.service;

import com.feeapp.feenotifier.domain.User.User;
import com.feeapp.feenotifier.domain.User.UserList;
import com.feeapp.feenotifier.domain.User.login.LoginCredentials;
import com.feeapp.feenotifier.spi.enums.AccountStatus;

public interface UserDBService {

  User addUser(User user);

  UserList getUsers();

  User findUser(LoginCredentials loginCredentials);

  User getUserByEmailId(String email);

  User getUserByUserId(String userId);

  Boolean findEmail(String email);

  void setAccountActive(AccountStatus status, String email);
}
