package com.example.activity_tracker;

public interface UserService {
    User getUserByEmailAndPassword(String email, String password);
}
