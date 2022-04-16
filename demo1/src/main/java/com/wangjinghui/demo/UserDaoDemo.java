package com.wangjinghui.demo;

import com.wangjinghui.dao.Impl.UserDaoImpl;
import com.wangjinghui.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save();
        System.out.println(userDao);
//        UserDao userDao1 = new UserDaoImpl();
//        userDao1.save();
        UserDao userDao2 = (UserDao) context.getBean("userDao");
        System.out.println(userDao2);

    }
}
