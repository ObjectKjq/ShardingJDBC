package com.kdf.shardingjdbc.service.impl;

import com.kdf.shardingjdbc.mapper.UserMapper;
import com.kdf.shardingjdbc.model.User;
import com.kdf.shardingjdbc.service.UserService;
// import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public List<User> findUsers() {
        return userMapper.findUsers();
    }

}
