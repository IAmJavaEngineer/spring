package com.spring.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.pojo.Role;
import com.spring.pojo.User;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    //展示角色数据
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        int pageSize = 10;
        Page<Object> page = PageHelper.startPage(pn, pageSize);
        //startPage紧跟着的这个查询就是一个分页
        List<Role> roleList = roleService.list();
        //使用PageInfo包装查询后的结果
        PageInfo<Role> pageInfo = new PageInfo<>(roleList, 5);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    //新增角色数据
    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/role/list";
    }

    //删除数据
    @RequestMapping("/del/{roleId}")
    public String del (@PathVariable("roleId") Long roleId) {
        roleService.del(roleId);
        return "redirect:/role/list";
    }



}
