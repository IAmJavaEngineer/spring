package com.spring.service;

import com.spring.pojo.User;

import java.util.List;

public interface UserService {

    List<User> list();

    void save(User user, Long[] roleIds);

    void del(Long userId);

    User login(String id, String username, String password);

    User getUserByUserId(Long userId);

    void update(User user, Long[] roleIds);

    int count();
}
