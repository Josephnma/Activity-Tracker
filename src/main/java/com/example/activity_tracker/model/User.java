package com.example.activity_tracker.model;

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;


@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;

}
