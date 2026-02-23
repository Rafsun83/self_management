package com.example.self_management.security.jwt;


import com.example.self_management.model.domain.RefreshToken;
import com.example.self_management.model.domain.User;
import com.example.self_management.persistence.entity.RefreshTokenEntity;
import com.example.self_management.persistence.entity.UserEntity;
import com.example.self_management.persistence.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public RefreshTokenEntity create(UserEntity userEntity) {
        RefreshTokenEntity refreshToken = new RefreshTokenEntity();
        refreshToken.setUserEntity(userEntity);
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpiresAt(Instant.now().plusMillis(604800000));

        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshTokenEntity verify(String refreshToken) {
        RefreshTokenEntity refreshTokenEntity = refreshTokenRepository.findByRefreshToken(refreshToken).orElseThrow(() -> new RuntimeException("Invalid refresh token") );

        if(refreshTokenEntity.getExpiresAt().isBefore(Instant.now())){
            refreshTokenRepository.delete(refreshTokenEntity);
            throw new RuntimeException("Refresh token expired");
        }
        return refreshTokenEntity;
    }

    public void deleteByUser(UserEntity userEntity) {
        refreshTokenRepository.deleteByUserEntity(userEntity);
    }
}
