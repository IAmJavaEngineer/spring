package com.spring.proxy.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect //标注当前MyAspect是一个切面类
public class MyAspect {

    //配置前置通知
    @Before("execution(* com.spring.proxy.anno.*.*(..))")
    public void before() {
        System.out.println("前置增强.........");
    }

    @AfterReturning("execution(* com.spring.proxy.anno.*.*(..))")
    public void afterReturning() {
        System.out.println("后置增强.........");
    }

    //ProceedingJoinPoint:  正在执行连接点==切点
//    @Around("execution(* com.spring.proxy.anno.*.*(..))")
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前增强.........");
        //切点方法
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后增强.........");
        return proceed;
    }

    @AfterThrowing("execution(* com.spring.proxy.anno.*.*(..))")
    public void afterThrowing() {
        System.out.println("异常抛出增强.........");
    }

//    @After("execution(* com.spring.proxy.anno.*.*(..))")
    @After("MyAspect.pointcut()")
    public void after() {
        System.out.println("最终增强.........");
    }

    @Pointcut("execution(* com.spring.proxy.anno.*.*(..))")
    public void pointcut() {}
}
