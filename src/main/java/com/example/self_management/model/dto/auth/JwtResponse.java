package com.example.self_management.model.dto.auth;

public class JwtResponse {
    private String token;
    public JwtResponse(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }
}
