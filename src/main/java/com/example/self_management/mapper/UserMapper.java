package com.example.self_management.mapper;


import com.example.self_management.model.domain.User;
import com.example.self_management.persistence.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User entityToDomain(UserEntity userEntity){
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }
}
