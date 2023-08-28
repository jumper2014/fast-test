package com.example.service;

import com.example.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {App.class})
public class RetryTest {

    @Autowired
    RetryService service;

    /**
     * Get result failed.
     * Get result failed.
     * Get result passed.
     */
    @Test
    public void testRetryTask() {
        service.performTask();
    }
}