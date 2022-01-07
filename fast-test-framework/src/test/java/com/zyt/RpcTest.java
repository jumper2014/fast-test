package com.zyt;

import com.zyt.dubbo.api.model.User;
import com.zyt.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class RpcTest {
    @Reference(interfaceName = "com.zyt.dubbo.api.model.User")
    private UserService userService;

    @Test
    public void getUser() {
        User user = userService.findUserById(1);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getTel());



    }

}
