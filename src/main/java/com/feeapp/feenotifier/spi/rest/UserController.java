package com.feeapp.feenotifier.spi.rest;

import com.feeapp.feenotifier.domain.User.User;
import com.feeapp.feenotifier.domain.User.UserList;
import com.feeapp.feenotifier.domain.User.login.LoginCredentials;
import com.feeapp.feenotifier.domain.User.login.LoginResponse;
import com.feeapp.feenotifier.domain.User.signup.SignupResponse;
import com.feeapp.feenotifier.domain.response.Response;
import com.feeapp.feenotifier.spi.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(path = "/fn/v1")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(
      path = "/login",
      produces = {MediaType.APPLICATION_JSON_VALUE},
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Response<LoginResponse>> login(
      @RequestBody LoginCredentials loginCredentials) {
    return new ResponseEntity<>(
        new Response<>(userService.userLogin(loginCredentials), null), HttpStatus.OK);
  }

  @PostMapping(
      path = "/signup",
      produces = {MediaType.APPLICATION_JSON_VALUE},
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Response<SignupResponse>> addNewUser(@RequestBody User user) {
    return new ResponseEntity<>(new Response<>(userService.addNewUser(user), null), HttpStatus.OK);
  }

  @GetMapping(
      path = "/get-all-users",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Response<UserList>> getAllUsers() {
    UserList userList = userService.getAllUsers();
    return new ResponseEntity<>(new Response<>(userList, null), HttpStatus.OK);
  }

  @GetMapping(
      path = "/get-user-userId",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Response<User>> getuserByUserId(@RequestParam String userId) {
    return new ResponseEntity<>(
        new Response<>(userService.getUserByUserId(userId), null), HttpStatus.OK);
  }

  // check Email is present or not in db
  @PostMapping(
      path = "/check-email",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<Response<Boolean>> checkEmailRegistration(@RequestParam String email) {
    return new ResponseEntity<>(
        new Response<Boolean>(userService.findEmail(email), null), HttpStatus.OK);
  }
}
