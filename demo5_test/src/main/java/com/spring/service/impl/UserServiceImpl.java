package com.spring.service.impl;

import com.spring.mapper.RoleMapper;
import com.spring.mapper.UserMapper;
import com.spring.mapper.User_RoleMapper;
import com.spring.pojo.*;
import com.spring.service.UserService;
import com.spring.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    User_RoleMapper user_roleMapper;

    @Override
    public List<User> list() {

        List<User> userList = SqlSessionUtils.getSession().getMapper(UserMapper.class).selectByExample(null);
        for (User user : userList) {
//            获得user的id
            Long id = user.getId();
//            int i = id.intValue();
//            将id作为参数，查询当前userId对应的Role数据
            User_RoleExample user_roleExample = new User_RoleExample();
            user_roleExample.createCriteria().andUseridEqualTo(user.getId());
            List<User_RoleKey> user_roleKeys = user_roleMapper.selectByExample(user_roleExample);
            List<Role> roleList = new ArrayList<>();
            for (User_RoleKey user_roleKey : user_roleKeys) {
                Long roleid = user_roleKey.getRoleid();
                Role role = roleMapper.selectByPrimaryKey(roleid);
                roleList.add(role);
            }
            user.setRoles(roleList);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //第一步向sys_user保存数据
        userMapper.insert(user);
        //向sys_user_role中存储多条数据
        user_roleMapper.insert(user.getId(),roleIds);
    }

    @Override
    public void del(Long userId) {
        //先删除关系表再删除user表
        User_RoleExample user_roleExample = new User_RoleExample();
        user_roleExample.createCriteria().andUseridEqualTo(userId);
        user_roleMapper.deleteByExample(user_roleExample);
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public User login(String id, String username, String password) {
        Long idL = Long.valueOf(id);
        User user = userMapper.selectByPrimaryKey(idL);
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User getUserByUserId(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public void update(User user, Long[] roleIds) {
        //先修改用户表数据
        System.out.println(user.getId());
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(user.getId());
        userMapper.updateByExample(user,userExample);
        //再修改关系表数据
        //采取删除再添加的方式
        User_RoleExample user_roleExample = new User_RoleExample();
        user_roleExample.createCriteria().andUseridEqualTo(user.getId());
        user_roleMapper.deleteByExample(user_roleExample);
        user_roleMapper.insert(user.getId(), roleIds);
    }

    @Override
    public int count() {
        int count = userMapper.countByExample(null);
        return count;
    }
}
