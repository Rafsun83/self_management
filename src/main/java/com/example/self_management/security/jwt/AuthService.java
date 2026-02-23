package com.example.self_management.security.jwt;

import com.example.self_management.model.dto.auth.JwtResponse;
import com.example.self_management.model.dto.auth.LoginRequest;
import com.example.self_management.persistence.entity.RefreshTokenEntity;
import com.example.self_management.persistence.entity.UserEntity;
import com.example.self_management.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final UserRepository userRepository;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService, RefreshTokenService refreshTokenService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService;
        this.userRepository = userRepository;
    }

    public JwtResponse login(LoginRequest loginRequest) {
//        System.out.println("LOGIN DATA: " + loginRequest.getUsername() + loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserEntity userEntity = userRepository.findByUsername(loginRequest.getUsername()).get();
        String accessToken = jwtService.generateToken(userEntity);
        RefreshTokenEntity refreshTokenEntity = refreshTokenService.create(userEntity);
        System.out.println("Access token: " + accessToken);
        return new JwtResponse(accessToken, refreshTokenEntity.getRefreshToken());

    }

    public JwtResponse refreshToken(String refreshToken) {
        RefreshTokenEntity refreshTokenEntity = refreshTokenService.verify(refreshToken);
        UserEntity userEntity = refreshTokenEntity.getUserEntity();

        String newAccessToken = jwtService.generateToken(userEntity);
        return new JwtResponse(newAccessToken, refreshToken);
    }

    public void logout(String accessToken) {
        RefreshTokenEntity refreshTokenEntity = refreshTokenService.verify(accessToken);
        refreshTokenService.deleteByUser(refreshTokenEntity.getUserEntity());
    }
}
