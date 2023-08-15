package com.example.config;

import com.example.beans.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
基于java配置方式
 */
@Configuration
public class MyBeanConfiguration {

    @Bean
    public UserBean user() {
        return new UserBean("Tester", 18);
    }
}
