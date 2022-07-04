package com.example.activity_tracker.controller;

import com.example.activity_tracker.dto.UserSignUpDto;
import com.example.activity_tracker.model.User;
import com.example.activity_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void createUser(@Validated @RequestBody User user){
        userService.createUser(new  UserSignUpDto());
    }
}