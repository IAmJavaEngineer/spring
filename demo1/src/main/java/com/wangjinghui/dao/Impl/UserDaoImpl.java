package com.wangjinghui.dao.Impl;

import com.wangjinghui.dao.UserDao;
import com.wangjinghui.pojo.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private List<String> strList;
    private List<User> users;
    private Map<String, User> userMap;
//    Properties和Map集合差不多，也是键值对，只不过Properties的值只能是字符串
    private Properties properties;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private String userName;
    private int age;

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDaoImpl{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建.....");
    }

    public void init() {
        System.out.println("初始化方法...");
    }

    @Override
    public void save() {
        System.out.println(strList);
        System.out.println(users);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println("save running.....");
    }

    public void destroy() {
        System.out.println("销毁方法...");
    }

//    public void setUserDao(UserDaoImpl userDao) {
//    }
}
