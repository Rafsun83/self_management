package com.example.self_management.controller;

import com.example.self_management.model.domain.User;
import com.example.self_management.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name="users", description = "For ALL Users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(summary = "Get All users", description = "Get for all users")
    @GetMapping
    public List<User> getAllUsers(@ParameterObject Pageable pageable){
        return userService.getAllUsers(pageable);

    }
}
