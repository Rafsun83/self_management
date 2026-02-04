package com.example.self_management.controller;

import com.example.self_management.model.dto.auth.JwtResponse;
import com.example.self_management.model.dto.auth.LoginRequest;
import com.example.self_management.security.jwt.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    //TEMP user later replace with DB
    private final String USERNAME = "admin";
    private final String PASSWORD = new BCryptPasswordEncoder().encode("password");

    public AuthController (JwtService jwtService, PasswordEncoder passwordEncoder){
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request ){
        if (!USERNAME.equals(request.getUsername()) || !passwordEncoder.matches(request.getPassword(), PASSWORD)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = jwtService.generateToken(request.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));

    }
}
