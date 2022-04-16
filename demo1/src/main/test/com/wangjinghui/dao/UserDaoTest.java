package com.wangjinghui.dao;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest extends TestCase {

    @Test
    //测试scope属性
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        System.out.println(userDao);
//        UserDao userDao1 = (UserDao) context.getBean("userDao");
//        System.out.println(userDao1);
        ((ClassPathXmlApplicationContext) context).close();

    }

}