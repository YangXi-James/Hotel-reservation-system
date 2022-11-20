package com.example.springboot.service;

import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getOneById(long userId){
        return userMapper.selectById(userId);
    }
}
