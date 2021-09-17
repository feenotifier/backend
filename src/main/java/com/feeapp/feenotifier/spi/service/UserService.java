package com.feeapp.feenotifier.spi.service;

import com.feeapp.feenotifier.domain.User.User;
import com.feeapp.feenotifier.domain.User.UserList;
import com.feeapp.feenotifier.domain.User.login.LoginCredentials;
import com.feeapp.feenotifier.domain.User.login.LoginResponse;
import com.feeapp.feenotifier.domain.User.signup.SignupResponse;
import com.feeapp.feenotifier.spi.db.service.UserDBService;
import com.feeapp.feenotifier.spi.enums.UserLoginResponse;
import com.feeapp.feenotifier.spi.enums.UserSignUpResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {
    private final UserDBService userDBService;

    public UserService(UserDBService userDBService) {
        this.userDBService = userDBService;
    }


    public SignupResponse addNewUser(User user) {
        SignupResponse signupResponse=new SignupResponse();
        if(userDBService.getUserByEmailId(user.getEmail())!=null){
          signupResponse.setResponse(UserSignUpResponse.EMAIL_ALREADY_EXISTS);
          signupResponse.setIsCreated(false);
          return signupResponse;
        }
        try{
            user=userDBService.addUser(user);
        }
        catch (Exception e){
            signupResponse.setResponse(UserSignUpResponse.UNKOWN_ERROR);
            signupResponse.setIsCreated(false);
            return signupResponse;
        }
        signupResponse.setIsCreated(true);
        signupResponse.setUserId(user.getUserId());
        signupResponse.setEmail(user.getEmail());
        signupResponse.setResponse(UserSignUpResponse.SUCCESS);
        return signupResponse;
    }

    public UserList getAllUsers() {
        return userDBService.getUsers();
    }
    public LoginResponse userLogin(LoginCredentials loginCredentials) {
        User user = userDBService.findUser(loginCredentials);
        LoginResponse loginResponse = new LoginResponse();
        if (user == null) {
            loginResponse.setIsLogin(false);
            loginResponse.setResponse(UserLoginResponse.INVALID_EMAIL_OR_PASSWORD);
            loginResponse.setEmail(null);
            return loginResponse;
        }
        loginResponse.setIsLogin(true);
        loginResponse.setResponse(UserLoginResponse.SUCCESS);
        loginResponse.setEmail(user.getEmail());
        loginResponse.setUserId(user.getUserId());
        return loginResponse;
    }

}
