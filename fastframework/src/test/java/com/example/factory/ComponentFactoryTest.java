package com.example.factory;

import com.example.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static com.example.factory.ComponentFactory.getBean;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {App.class})
public class ComponentFactoryTest {

    @Test
    public void testInitBean() {
        UserFactory userFactory = getBean(UserFactory.class);
        userFactory.create("John", 30);
        System.out.println(userFactory);
    }
}
