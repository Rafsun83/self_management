package com.example.self_management.persistence.repository;

import com.example.self_management.persistence.entity.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Long> {
    Optional<RefreshTokenEntity> findByToken(String token);
//    void deleteByUserEntity(UserEntity userEntity);
    List<RefreshTokenEntity> findByDeviceIdAndIsActiveTrue(String deviceId);
    int countByDeviceIdAndIsActiveTrue(String deviceId);

}
