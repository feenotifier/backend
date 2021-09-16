package com.feeapp.feenotifier.service;

import com.feeapp.feenotifier.db.service.UserDBService;
import com.feeapp.feenotifier.models.User;
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

}
