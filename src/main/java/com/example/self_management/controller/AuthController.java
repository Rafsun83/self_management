package com.example.self_management.controller;

import com.example.self_management.model.domain.User;
import com.example.self_management.model.dto.auth.JwtResponse;
import com.example.self_management.model.dto.auth.LoginRequest;
import com.example.self_management.model.dto.user.CreateUserRequest;
import com.example.self_management.persistence.entity.UserEntity;
import com.example.self_management.persistence.repository.UserRepository;
import com.example.self_management.security.jwt.JwtService;
import com.example.self_management.service.UserService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRepository userRepository;


    public AuthController (JwtService jwtService, PasswordEncoder passwordEncoder, UserService userService, UserRepository userRepository){
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.userRepository = userRepository;

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request ){
        UserEntity userEntity = userRepository.findByUsername(request.getUsername()).orElse(null);



        if (userEntity == null || !passwordEncoder.matches(request.getPassword(), new BCryptPasswordEncoder().encode(userEntity.getPassword()) )){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = jwtService.generateToken(userEntity.getUsername(), userEntity.getId());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/registration")
    public Long registration(@RequestBody CreateUserRequest createUserRequest){
        return userService.createUser(createUserRequest);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(@ParameterObject Pageable pageable){
        return userService.getAllUsers(pageable);

    }

}
