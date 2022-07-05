package com.example.activity_tracker.controller;

import com.example.activity_tracker.dto.UserResponseDto;
import com.example.activity_tracker.dto.UserSignUpDto;
import com.example.activity_tracker.model.User;
import com.example.activity_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserSignUpDto createUser(@Validated @RequestBody UserSignUpDto userSignUpDto){
//        UserSignUpDto users = new UserSignUpDto();
//        users.setName(user.getFirstName());
//        users.setAddress(user.getAddress());
//        users.setEmail(user.getEmail());
//        users.setPassword(user.getPassword());
        userService.createUser(userSignUpDto);
        return userSignUpDto;
    }

    @PostMapping("/login")
    public ResponseEntity<List<UserResponseDto>> login(@Validated @RequestBody User user){
        userService.getUser(user.getEmail());
        userService.getUser(user.getPassword());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    }