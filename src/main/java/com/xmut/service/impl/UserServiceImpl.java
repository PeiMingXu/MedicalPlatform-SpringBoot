package com.xmut.service.impl;

import com.xmut.mapper.UserMapper;
import com.xmut.pojo.User;
import com.xmut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author UserServiceImpl
 * @date: 2024/1/7 16:36
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;


    //登陆
    @Override
    public User login(User user) {
        return userMapper.findUserByPhoneAndPassword(user);
    }
}
