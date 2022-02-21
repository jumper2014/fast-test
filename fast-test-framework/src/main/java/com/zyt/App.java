package com.zyt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 */
@SpringBootApplication
@ComponentScan(value = "com.zyt.weyland")
public class App {
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

        System.out.println("Hello World!");
    }
}
