package com.example.sp;

import com.example.App;
import com.example.beans.UserBean;
import com.example.config.MyBeanConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class BeanConfigurationTest {

    @Test
    public void myTest() {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MyBeanConfiguration.class);
        UserBean user = applicationContext.getBean("user", UserBean.class);
        System.out.println(user);

    }
}
