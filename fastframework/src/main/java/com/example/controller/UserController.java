package com.example.controller;

import com.example.annotation.Action;
import com.example.beans.UserBean;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {

    @RequestMapping("/all")
    @Action(value = "findAll users")
    public List<UserBean> findAll() {
        List<UserBean> users = new ArrayList();
        UserBean user = new UserBean();
        user.setAge(10);
        user.setName("John");
        users.add(user);
        return users;
    }

    @GetMapping("/{userId}")
    @Action(value = "find user via id")
    public UserBean findUser(@PathVariable("userId") String userId) {
        UserBean user = new UserBean();
        user.setAge(10);
        user.setName("User" + userId);
        return user;
    }




}
