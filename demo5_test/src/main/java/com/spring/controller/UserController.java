package com.spring.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.pojo.Role;
import com.spring.pojo.User;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    //展示数据
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
//        Integer count = userService.count();
        int pageSize = 10;
//        if (pn < 1) {
//            pn = 1;
//        } else if (pn > count / pageSize) {
//            if (count % pageSize > 0) {
//                pn = count / pageSize + 1;
//            } else {
//                pn = count / pageSize;
//            }
//        }
        Page<Object> page = PageHelper.startPage(pn, pageSize);
        //startPage紧跟着的这个查询就是一个分页
        List<User> userList = userService.list();
        //使用PageInfo包装查询后的结果
        PageInfo<User> pageInfo = new PageInfo<>(userList, 5);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    //添加数据页面,主要是得到角色信息
    @RequestMapping("/saveUI")
    public ModelAndView saveUI() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList =roleService.list();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    //保存数据
    @RequestMapping("/save")
    public String save(User user, Long[] roleIds) {
        userService.save(user,roleIds);
        return "redirect:/user/list";

    }

    //删除数据
    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") Long userId) {
        userService.del(userId);
        return "redirect:/user/list";
    }

    @RequestMapping("/login")
    public String login(String id, String username,String password,HttpSession session){
        User user = userService.login(id,username,password);
        LOGGER.info("Hello, {}", username);
        LOGGER.error("Hello, {}", username);
        if(user!=null){
            //登录成功  将user存储到session
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("/updateUI/{userId}")
    public ModelAndView updateUI(@PathVariable("userId") Long userId) {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList =roleService.list();
        User user = userService.getUserByUserId(userId);
        System.out.println("id = " + user.getId());
        modelAndView.addObject("roleList", roleList);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-update");
        return modelAndView;
    }

    @RequestMapping("update")
    public String update(User user, Long[] roleIds, HttpServletRequest request) {
        String id = request.getParameter("id");
        Long userId = Long.valueOf(id);
        System.out.println(user);
        user.setId(userId);
        userService.update(user, roleIds);
        return "redirect:/user/list";
    }
}
