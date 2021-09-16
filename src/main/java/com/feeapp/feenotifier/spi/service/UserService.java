package com.feeapp.feenotifier.spi.service;

import com.feeapp.feenotifier.domain.User.User;
import com.feeapp.feenotifier.domain.User.UserList;
import com.feeapp.feenotifier.domain.User.login.LoginCredentials;
import com.feeapp.feenotifier.domain.User.login.LoginResponse;
import com.feeapp.feenotifier.spi.db.service.UserDBService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {
    private final UserDBService userDBService;

    public UserService(UserDBService userDBService) {
        this.userDBService = userDBService;
    }


    public String addNewUser(User user) {
        return userDBService.addUser(user);
    }

    public UserList getAllUsers() {
        return userDBService.getUsers();
    }

    public LoginResponse userLogin(LoginCredentials loginCredentials) {
        User user = userDBService.findUser(loginCredentials);
        LoginResponse loginResponse = new LoginResponse();
        if (user == null) {
            loginResponse.setIsLogin(false);
            loginResponse.setResponse("user not found");
            loginResponse.setEmail(null);
            return loginResponse;
        }
        loginResponse.setIsLogin(true);
        loginResponse.setResponse("logged in");
        loginResponse.setEmail(user.getEmail());
        return loginResponse;
    }

}
