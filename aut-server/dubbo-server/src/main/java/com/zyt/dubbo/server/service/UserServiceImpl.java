package com.zyt.dubbo.server.service;

import com.zyt.dubbo.api.model.User;
import com.zyt.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Service;

//此处的@Service是dubbo下的注解，不是spring的注解
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("zyt");
        user.setPassword("123456");
        user.setTel("13810002000");
        return user;
    }
}