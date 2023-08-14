package com.example.factory;

import com.example.beans.UserBean;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserFactory {
    @Autowired
    UserBean user;

    public void create(String name, int age) {
        user.setName(name);
        user.setAge(age);
    }

    @Override
    public String toString() {
        return "UserFactory [name=" + user.getName() + ", age=" + user.getAge() + "]";
    }
}
