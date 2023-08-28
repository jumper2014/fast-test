package com.example.exception;

import com.example.App;
import com.example.beans.UserBean;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {App.class})
public class ValidateUserExceptionTest {

    @Autowired
    UserBean user;




    @Test(expected = AppException.class)
    public void validateAge1() {
        user.setAge(-1);
       user.validateAge();
    }

    @Test
    public void validateAge2() {
        user.setAge(-1);
        AppException exception = Assertions.assertThrows(AppException.class, () -> {
            user.validateAge();
        });

    }
}
