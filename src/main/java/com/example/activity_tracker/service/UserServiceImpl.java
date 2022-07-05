

package com.example.activity_tracker.service;

import com.example.activity_tracker.dto.UserSignUpDto;
import com.example.activity_tracker.dto.UserUpdateDto;
import com.example.activity_tracker.model.User;
import com.example.activity_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.persistence.Table;
import java.util.List;

@Service

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;


    @Override
    public void createUser(UserSignUpDto userSignupDto) {
        User user1 = new User();
        user1.setName(userSignupDto.getName());
        user1.setEmail(userSignupDto.getEmail());
        user1.setPassword(userSignupDto.getPassword());
        user1.setAddress(userSignupDto.getAddress());
        userRepo.save(user1);
    }

    @Override
    public User getUser(String email) {
        User user = userRepo.findByEmail(email);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList= userRepo.findAll();
        return userList;
    }

    @Override
    public User updateUser(UserUpdateDto userUpdateDto, String email) {
        User user = userRepo.findByEmail(email);
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setAddress(user.getAddress());
        return  userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}