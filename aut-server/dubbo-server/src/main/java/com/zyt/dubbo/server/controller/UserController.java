package com.zyt.dubbo.server.controller;

import com.zyt.dubbo.api.model.User;
import com.zyt.dubbo.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/user", produces="application/json")
//@CrossOrigin(origins="*") // 允许跨域
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Integer id) {
        User user = userService.findUserById(id);
        return user;
    }

    @PostMapping("/{id}")
    public User addUserById(@PathVariable("id") Integer id)  {
        User user = userService.findUserById(id);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id") Integer id)  {
        User user = userService.findUserById(id);
        return user;
    }

    @DeleteMapping("/{id}")
    public User deleteUserById(@PathVariable("id") Integer id)  {
        User user = userService.findUserById(id);
        return user;
    }

}
