package cn.enilu.flash.api.aop;

import cn.enilu.flash.api.annotation.DSource;
import cn.enilu.flash.api.config.DynamicDatasource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * 系统日志切面
 * @author zhuzhe
 * @date 2018/6/4 9:27
 * @email 1529949535@qq.com
 */
@Aspect  // 使用@Aspect注解声明一个切面
@Component
public class DSourceAspect {

    /**
     * 这里我们使用注解的形式
     * 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method
     * 切点表达式:   execution(...)
     */
    @Pointcut("@annotation(cn.enilu.flash.api.annotation.DSource)")
    public void changeDSourcePointCut() {}

    /**
     * 环绕通知 @Around  ， 当然也可以使用 @Before (前置通知)  @After (后置通知)
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("changeDSourcePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获得源的名字
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        DSource source = method.getAnnotation(DSource.class);
        String dataSourceName = source.value();

        // 设置新源
        DynamicDatasource.setCurrentDatasource(dataSourceName);
        System.out.println("Change data source to: " + dataSourceName);
        // 原有逻辑
        Object result = joinPoint.proceed();
        // 恢复默认源
        DynamicDatasource.restoreDatasource();
        System.out.println("Change data source to default ");
        return result;
    }


}