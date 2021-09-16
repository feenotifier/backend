package com.feeapp.feenotifier.spi.service;

import com.feeapp.feenotifier.domain.User.User;
import com.feeapp.feenotifier.domain.User.UserList;
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


    public void addNewUser(User user) {
        userDBService.addUser(user);
    }

    public UserList getAllUsers() {
        return userDBService.getUsers();
    }

}
