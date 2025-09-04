package com.kdf.shardingjdbc.service;

import com.kdf.shardingjdbc.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> findUsers();

}
