package com.spring.service.Impl;

import com.spring.dao.UserDao;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userservice" class="com.spring.service.Impl.UserServiceImpl">

//</bean>
//@Component("userservice")
@Service("userservice")
@Scope("prototype")
public class UserServiceImpl implements UserService {

//    @Value("com.mysql.cj.jdbc.Driver")    //菜鸟用法
    @Value("${jdbc.driver}")                //高大上用法
    private String driver;


//    <property name="userDao" ref="userDao"></property>
//    @Autowired  //按照数据类型从Spring容器中进行匹配的
//    @Qualifier("userDao")   //是按照id只从容器进行匹配的，但是主要此处@Qualifier要结合@Autowired一起使用
    @Resource(name = "userDao") //相当于@Qualifier+@Autowired, 按照名称注入
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

//    用注解方式set方法可以不写
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        userDao.save();
        System.out.println(driver);
    }

    @PostConstruct
    public void init() {
        System.out.println("Service对象的初始化方法");
    }

    @PreDestroy
    public void destory() {
        System.out.println("Service对象的销毁方法");
    }
}
