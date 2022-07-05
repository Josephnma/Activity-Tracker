package com.example.activity_tracker.service.impl;

import com.example.activity_tracker.dto.SignupDto;
import com.example.activity_tracker.model.User;
import com.example.activity_tracker.repository.UserRepository;
import com.example.activity_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {
        @Autowired
        private UserRepository userRepo;


    @Override
    public void createUser(SignupDto signupDto) {
        User user1 = User.builder()
                .firstName(signupDto.getFirstName())
                .lastName(signupDto.getLastName())
                .email(signupDto.getEmail())
                .password(signupDto.getPassword())
                .build();

            userRepo.save(user1);
    }

}