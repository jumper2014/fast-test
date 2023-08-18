package com.example.annotation;

import java.lang.annotation.*;

// used to decorate controller method for logging
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String value() default "";
}
