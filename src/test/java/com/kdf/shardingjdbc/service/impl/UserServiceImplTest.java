package com.kdf.shardingjdbc.service.impl;

import com.kdf.shardingjdbc.model.User;
import com.kdf.shardingjdbc.service.UserService;
// import jakarta.annotation.Resource;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    void addUser() {
        User user = new User();
        // user.setId(1);
        user.setNickname("张三");
        user.setPassword("123456");
        user.setSex(1);
        user.setBirthday("1990-01-01");
        userService.addUser(user);
    }

    @Test
    void findUsers() {
        // 对于一致性要求强的设置强制查询路游到主库
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
        List<User> users = userService.findUsers();
        System.out.println(users);
    }

}