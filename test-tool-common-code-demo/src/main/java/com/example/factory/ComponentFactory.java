package com.example.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ComponentFactory implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ComponentFactory.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String beanName) throws BeansException {
        return applicationContext.getBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> clazz) throws BeansException {
        return applicationContext.getBean(beanName, clazz);
    }

    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return applicationContext.getBean(clazz);
    }

    public static Object getBean(String beanName, Object... args) throws BeansException {
        return applicationContext.getBean(beanName, args);
    }

    public static <T> T getBean(Class<T> clazz, Object... args) throws BeansException {
        return applicationContext.getBean(clazz, args);
    }
}
