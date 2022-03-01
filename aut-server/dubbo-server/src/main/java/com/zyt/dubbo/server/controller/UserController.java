package com.zyt.dubbo.server.controller;


import com.zyt.dubbo.api.model.User;
import com.zyt.dubbo.api.service.UserService;
import com.zyt.dubbo.server.common.DataType;
import com.zyt.dubbo.server.common.ParamType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/user", produces="application/json")
@Api(tags = "API", value = "用户管理")
//@CrossOrigin(origins="*") // 允许跨域
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "主键查询（DONE）", notes = "备注")
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)
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
