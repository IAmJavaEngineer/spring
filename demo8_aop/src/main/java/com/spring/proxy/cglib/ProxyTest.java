package com.spring.proxy.cglib;

import com.spring.proxy.jdk.TargetIterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(final String[] args) {
        //创建被代理对象
        final Target target = new Target();

        //增强对象
        final Advice advice = new Advice();

        //返回值时动态生成的代理对象  基于cglib
        //1、创建增强器
        Enhancer enhancer = new Enhancer();
        //2、设置父类（目标）
        enhancer.setSuperclass(Target.class);
        //3、设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //执行前置
                advice.before();
                Object invoke = method.invoke(target, args);    //执行被代理对象的方法
                //执行后置
                advice.afterReturning();
                return invoke;
            }
        });
        //4、创建代理对象
        Target target1 = (Target) enhancer.create();
        target1.save();
    }
}
