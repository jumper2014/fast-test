package com.example.framework.env;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="classpath:${test.config.name}")
public class EnvConfig {

}