package com.example.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RetryService {
    public ArrayList<Boolean> results =  new ArrayList<>(Arrays.asList(false, false, true));

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public void performTask() {
        try {
            if(!results.get(0)) {
                results.remove(0);
                System.out.println("Get result failed.");
                throw new RuntimeException("Task execution failed");
            } else {
                System.out.println("Get result passed.");
            }

        } catch (Exception e) {
            // 异常处理逻辑
            // 可以选择重新抛出异常，以触发重试
            throw e;
        }
    }
}
