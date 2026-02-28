package com.example.self_management.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "refresh_tokens")
public class RefreshTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    private LocalDateTime expiryDate;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private UserEntity userEntity;


    public RefreshTokenEntity() {}

    public RefreshTokenEntity(String token, UserEntity userEntity, LocalDateTime expiryDate) {
        this.token = token;
        this.userEntity = userEntity;
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRefreshToken() {
        return token;
    }
    public void setRefreshToken(String refreshToken) {
        this.token = refreshToken;
    }
    public UserEntity getUserEntity() {
        return userEntity;
    }
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
    public LocalDateTime getExpiresAt() {
        return expiryDate;
    }
    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiryDate = expiresAt;
    }
}
