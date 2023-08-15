package com.example.annotation;

import com.example.utils.MethodUtil;
import org.junit.Test;

public class TestMethodNameTest {

    @Test
    @TestMethodName
    public void doSomethingTest() {
        System.out.println("test method name: " + MethodUtil.getName());
    }
}
