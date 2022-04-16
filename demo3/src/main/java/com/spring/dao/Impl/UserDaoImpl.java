package com.spring.dao.Impl;

import com.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("UserDaoImpl.save running.....");
    }
}
