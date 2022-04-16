package com.spring.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //创建被代理对象
        final Target target = new Target();

        //增强对象
        final Advice advice = new Advice();

        //返回值时动态生成的代理对象
        TargetIterface proxy = (TargetIterface) Proxy.newProxyInstance(
            target.getClass().getClassLoader(),     //被代理对象类加载器
            target.getClass().getInterfaces(),      //被代理对象实现的接口字节码对象数组
            new InvocationHandler() {
                //调用代理对象的任何方法实际都是执行invoke方法
                //proxy代理对象     method被代理对象要执行的方法字节码对象  args被代理对象执行方法所需要的参数列表
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    //前置增强
                    advice.before();
                    //执行被代理对象的方法
                    Object invoke = method.invoke(target, args);//反射
                    //后置增强
                    advice.afterReturning();
                    return invoke;              //这里的返回值时代理对象执行方法的返回值
                }
            }
        );

        //调用代理对象的方法
        proxy.save();
    }
}
