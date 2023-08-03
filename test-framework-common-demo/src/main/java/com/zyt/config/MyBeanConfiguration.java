package com.zyt.config;

import com.zyt.beans.BUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
基于java配置方式
 */
@Configuration
public class MyBeanConfiguration {

    @Bean
    public BUser user() {
        return new BUser("Tester", 18);
    }
}