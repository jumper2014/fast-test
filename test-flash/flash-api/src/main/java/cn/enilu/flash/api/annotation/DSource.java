package cn.enilu.flash.api.annotation;

import java.lang.annotation.*;

/**
 * 切换JPA数据源的注解
 * @author ijumper
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DSource {

    // value作为data source
    String value() default  "";

}
