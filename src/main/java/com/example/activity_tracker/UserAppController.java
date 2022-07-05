package com.example.activity_tracker;

import com.example.activity_tracker.request.UserRequest;
import com.example.activity_tracker.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("api/v1")
public class UserAppController {

    @Autowired
    private UserService userServiceImpl;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest userRequest){
        UserResponse userResponse;
        User user = userServiceImpl
            .getUserByEmailAndPassword(userRequest.getEmail(),
                    userRequest.getPassword());

        if(Objects.isNull(user)){
            return new ResponseEntity<>("Incorrect username or password", HttpStatus.UNAUTHORIZED);
        }
        userResponse = new ModelMapper().map(user,
                UserResponse.class);
        log.info("Sending user object: ", userResponse);
        return new ResponseEntity<> (user, HttpStatus.OK);
    }

}