package com.example.self_management.service;

import com.example.self_management.mapper.UserMapper;
import com.example.self_management.model.domain.User;
import com.example.self_management.persistence.entity.UserEntity;
import com.example.self_management.persistence.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers(Pageable pageable){
        List<UserEntity> userEntityList = userRepository.findAll(pageable).getContent();
        return userEntityList.stream().map(userMapper::entityToDomain).toList();
    }
}
