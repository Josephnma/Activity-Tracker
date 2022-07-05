package com.example.activity_tracker.response;

import lombok.Data;

@Data
public class UserResponse {
    private String fullName;
    private String email;
    private String password;
}
