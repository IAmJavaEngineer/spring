package com.wangjinghui.demo;

import com.wangjinghui.dao.Impl.UserDaoImpl;
import com.wangjinghui.service.Impl.UserServiceImpl;
import com.wangjinghui.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
//        用UserService.class作为参数只适用于配置文件中只有一个bean对象的时候，如果有多个，那么di也会不一样，从而导致不知道找哪个id的bean
//        UserService userService = context.getBean(UserService.class);
        userService.save();

//        UserService userService1 = new UserServiceImpl();
//        userService1.save();
    }
}
