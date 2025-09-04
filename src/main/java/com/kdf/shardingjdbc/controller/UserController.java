package com.kdf.shardingjdbc.controller;

import com.kdf.shardingjdbc.model.User;
import com.kdf.shardingjdbc.service.UserService;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public Boolean addUser(@RequestBody User user) {
        // 获取用户信息
        userService.addUser(user);
        return true;
    }

    @GetMapping("/list")
    public List<User> list() {
        return userService.findUsers();
    }

    @GetMapping("/list2")
    public List<User> list2() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
        return userService.findUsers();
    }
}
