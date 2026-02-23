package com.example.self_management.mapper;


import com.example.self_management.model.dto.refreshToken.RequestRefreshToken;
import com.example.self_management.persistence.entity.RefreshTokenEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RefreshTokenMapper {

    public RefreshTokenEntity createRefreshTokenToRefreshTokenEntity(RequestRefreshToken requestRefreshToken) {
        RefreshTokenEntity refreshTokenEntity = new RefreshTokenEntity();
        BeanUtils.copyProperties(requestRefreshToken, refreshTokenEntity);
        return refreshTokenEntity;
    }
}
