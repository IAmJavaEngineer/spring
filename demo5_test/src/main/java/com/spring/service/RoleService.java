package com.spring.service;

import com.spring.pojo.Role;

import java.util.List;

public interface RoleService {
    public List<Role> list();

    void save(Role role);

    void del(Long roleId);
}
