package com.example.self_management.model.domain;

import com.example.self_management.persistence.entity.UserEntity;

import java.time.Instant;

public class RefreshToken {

    private Long id;
    private String refreshToken;
    private UserEntity userEntity;

    private Instant expiresAt;

    public RefreshToken() {}

    public RefreshToken(String refreshToken, UserEntity userEntity, Instant expiresAt) {
        this.refreshToken = refreshToken;
        this.userEntity = userEntity;
        this.expiresAt = expiresAt;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRefreshToken() {
        return refreshToken;
    }
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public UserEntity getUserEntity() {
        return userEntity;
    }
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
    public Instant getExpiresAt() {
        return expiresAt;
    }
    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }
}
