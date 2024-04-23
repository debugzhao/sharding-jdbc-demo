package com.example.shardingjdbcdemo.controller;

import com.example.shardingjdbcdemo.entity.User;
import com.example.shardingjdbcdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zhaojingchao
 * @Date 2024/04/22 15:30
 * @Email zhaojingchao@joysuch.com
 * @Desc
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("list")
    public void getAllUser() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
