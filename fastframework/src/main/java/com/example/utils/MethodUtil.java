package com.example.utils;

import com.example.annotation.TestMethodName;
import java.lang.reflect.Method;

public class MethodUtil {
    public static String getName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements) {
            try {
                Class<?> clazz = Class.forName(element.getClassName());
                Method method = clazz.getDeclaredMethod(element.getMethodName());
                if (method.isAnnotationPresent(TestMethodName.class)) {
                    return element.getMethodName();
                }
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                // 异常处理
            }
        }
        return null;
    }
}
