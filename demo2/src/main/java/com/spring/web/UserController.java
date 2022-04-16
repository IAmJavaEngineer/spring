package com.spring.web;

import com.spring.config.SpringConfiguration;
import com.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService bean = context.getBean(UserService.class);
        bean.save();
//        ((ClassPathXmlApplicationContext) context).close();
    }
}
