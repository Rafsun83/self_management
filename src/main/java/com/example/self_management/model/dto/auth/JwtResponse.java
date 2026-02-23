package com.example.self_management.model.dto.auth;

public class JwtResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String refreshToken;

    public JwtResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken(){
        return accessToken;
    }

    public String getRefreshToken(){
        return refreshToken;
    }
}
