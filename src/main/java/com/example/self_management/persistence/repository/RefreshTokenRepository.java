package com.example.self_management.persistence.repository;

import com.example.self_management.model.domain.User;
import com.example.self_management.persistence.entity.RefreshTokenEntity;
import com.example.self_management.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Long> {
    Optional<RefreshTokenEntity> findByRefreshToken(String refreshToken);
    void deleteByUserEntity(UserEntity userEntity);
}
