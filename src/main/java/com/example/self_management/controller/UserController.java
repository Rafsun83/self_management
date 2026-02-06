package com.example.self_management.controller;


import com.example.self_management.model.domain.User;
import com.example.self_management.service.UserService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUserDetails(){
        return userService.getUserDetails();
    }

    @GetMapping("/users")
    public List<User> getAllUsers(@ParameterObject Pageable pageable){
        return userService.getAllUsers(pageable);
    }
}
