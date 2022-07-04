package com.example.activity_tracker.service;

import com.example.activity_tracker.dto.UserSignUpDto;
import com.example.activity_tracker.dto.UserSignUpDto;
import com.example.activity_tracker.dto.UserUpdateDto;
import com.example.activity_tracker.model.User;

import java.util.List;

public interface UserService {
    void createUser(UserSignUpDto userSignupDto);
    User getUser(String email);
    List<User> getAllUser();
    User updateUser(UserUpdateDto userUpdateDto, String email);
    void deleteUser(Long id);
}
