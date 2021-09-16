package com.feeapp.feenotifier.spi.db.service.impl;

import com.feeapp.feenotifier.domain.User.User;
import com.feeapp.feenotifier.domain.User.UserList;
import com.feeapp.feenotifier.spi.db.entity.UserEntity;
import com.feeapp.feenotifier.spi.db.mapper.UserMapper;
import com.feeapp.feenotifier.spi.db.repository.UserRepository;
import com.feeapp.feenotifier.spi.db.service.UserDBService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public UserList getUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        UserList userList = new UserList();
        userList.setUsers(userEntities);
        return userList;
    }

}
