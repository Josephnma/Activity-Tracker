package com.example.activity_tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;


    public List<User> listAll(){
        return  userRepo.findAll();
    }

    public void createUser(User user){
        userRepo.save(user);
    }

    public User getUser(Integer id){
        return  userRepo.findById(id).get();
    }

    public void deleteUser(Integer id){
        userRepo.deleteById(id);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password){
        return userRepo.findByEmailAndAndPassword(email, password);
    }
}