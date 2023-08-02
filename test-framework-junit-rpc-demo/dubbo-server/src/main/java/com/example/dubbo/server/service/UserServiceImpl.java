package com.example.dubbo.server.service;

import com.example.dubbo.api.model.User;
import com.example.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Service;

//此处的@Service是dubbo下的注解，不是spring的注解
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("User" + id);
        user.setPassword("Passwd" + id );
        user.setTel("13811112222");
        user.setAddress("Test street No. " + id);
        return user;
    }
}
