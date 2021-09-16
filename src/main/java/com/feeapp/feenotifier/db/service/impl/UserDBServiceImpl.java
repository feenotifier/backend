package com.feeapp.feenotifier.db.service.impl;

import com.feeapp.feenotifier.db.UserRepository;
import com.feeapp.feenotifier.db.entity.UserEntity;
import com.feeapp.feenotifier.db.mapper.UserMapper;
import com.feeapp.feenotifier.db.service.UserDBService;
import com.feeapp.feenotifier.models.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserDBServiceImpl implements UserDBService {

    private final UserRepository userRepository;


    public UserDBServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        UserEntity userEntity = UserMapper.map(user);
        userRepository.save(userEntity);
        System.out.println(userEntity);
    }

}
