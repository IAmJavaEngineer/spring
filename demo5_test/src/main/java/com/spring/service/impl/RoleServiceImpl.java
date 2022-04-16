package com.spring.service.impl;


import com.spring.mapper.RoleMapper;
import com.spring.mapper.User_RoleMapper;
import com.spring.pojo.Role;
import com.spring.pojo.User_RoleExample;
import com.spring.service.RoleService;
import com.spring.utils.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private User_RoleMapper user_roleMapper;
    @Override
    public List<Role> list() {
        List<Role> roleList = SqlSessionUtils.getSession().getMapper(RoleMapper.class).selectByExample(null);
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void del(Long roleId) {
        //先删除关系表再删除角色表
        User_RoleExample user_roleExample = new User_RoleExample();
        user_roleExample.createCriteria().andRoleidEqualTo(roleId);
        user_roleMapper.deleteByExample(user_roleExample);
        roleMapper.deleteByPrimaryKey(roleId);
    }
}
