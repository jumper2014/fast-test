package com.example.dubbo.client.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dubbo.api.model.User;
import com.example.dubbo.api.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    @Reference  //注入要调用的服务
    private UserService userService;

    @RequestMapping("/user/{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id){
        //调用服务
        User user= userService.findUserById(id);
        return user;
    }

}