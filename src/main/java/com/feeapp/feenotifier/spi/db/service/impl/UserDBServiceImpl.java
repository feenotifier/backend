package com.feeapp.feenotifier.spi.db.service.impl;

import com.feeapp.feenotifier.domain.User.User;
import com.feeapp.feenotifier.domain.User.UserList;
import com.feeapp.feenotifier.domain.User.login.LoginCredentials;
import com.feeapp.feenotifier.domain.User.signup.SignupResponse;
import com.feeapp.feenotifier.spi.db.entity.UserEntity;
import com.feeapp.feenotifier.spi.db.mapper.EntityToUserMapper;
import com.feeapp.feenotifier.spi.db.mapper.UserToEntityMapper;
import com.feeapp.feenotifier.spi.db.repository.UserRepository;
import com.feeapp.feenotifier.spi.db.service.UserDBService;
import com.feeapp.feenotifier.spi.enums.UserSignUpResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class UserDBServiceImpl implements UserDBService {

    private final UserRepository userRepository;


    public UserDBServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SignupResponse addUser(User user) {
        UserEntity userEntity = UserToEntityMapper.map(user);
        SignupResponse signupResponse = new SignupResponse();
        try{
           userEntity = userRepository.save(userEntity);
        }
        catch (Exception e){
            signupResponse.setIsCreated(false);
            signupResponse.setResponse(UserSignUpResponse.UNKOWN_ERROR);
            return signupResponse;
        }
        signupResponse.setIsCreated(true);
        signupResponse.setUserId(userEntity.getUserId());
        signupResponse.setEmail(userEntity.getEmail());
        signupResponse.setResponse(UserSignUpResponse.SUCCESS);
        return signupResponse;

    }

    public UserList getUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        UserList userList = new UserList();
        userList.setUsers(userEntities);
        return userList;
    }

    public User findUser(LoginCredentials loginCredentials) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmailAndPassword(loginCredentials.getEmail(), loginCredentials.getPassword());
        if (userEntityOptional.isEmpty()) {
            return null;
        }
        return EntityToUserMapper.map(userEntityOptional.get());
    }

}
