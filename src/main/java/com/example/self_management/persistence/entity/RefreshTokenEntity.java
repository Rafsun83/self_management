package com.example.self_management.persistence.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "refresh_tokens")
public class RefreshTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String refreshToken;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @JsonIgnore
    private UserEntity userEntity;

    private Instant expiresAt;

    public RefreshTokenEntity() {}

    public RefreshTokenEntity(String refreshToken, UserEntity userEntity, Instant expiresAt) {
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
