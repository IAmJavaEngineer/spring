package com.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.pojo.User;
import com.spring.pojo.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    /**
     * 一下方法都是由SpringMVC框架来调用的，方法的参数也是由SpringMVC给的，Servlet中的参数，SpringMVC基本都有
     *
     */

    //请求地址  http://localhost:8080/demo3/user/quick
    @RequestMapping("/quick")
    public String save() {
        System.out.println("UserController save running");
        return "success";
//        return "forward:/success.jsp";    默认是转发
//        return "redirect/success.jsp";    重定向
    }

    @RequestMapping("/quick2")
    public ModelAndView save2() {
        /**
         * Model：模型 作用封装数据
         * View： 视图 作用展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "itcast");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.addObject("username","itheima");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     *
     * @param model Model是SpringMVC封装好的对象
     * @return
     */
    @RequestMapping("/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "尚硅谷");
        return "success";
    }

    /**
     *
     * @param request request是原生的servlet中的对象，tomcat产生的 （这种方式不常用了）
     * @return
     */
    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "张三");
        return "success";
    }

    /**
     * --------------回写数据-----------------
     */
    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response, HttpServletRequest request, HttpSession httpSession) throws IOException {
        response.getWriter().print("hello itcast");
        System.out.println(request);
        System.out.println(response);
        System.out.println(httpSession);
    }

    @RequestMapping("/quick7")
    @ResponseBody   //   1. 直接返回字符串
//                       ② 将需要回写的字符串直接返回，但此时需要通过@ResponseBody注解告知SpringMVC框架，方法
//                       返回的字符串不是跳转是直接在http响应体中返回。
    public String save7() throws IOException {
        return "hello itheima";
    }

    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() throws IOException {
        return "{\"username\":\"zhangsan\".\"age\":18}";
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("张三");
        user.setAge(99);
        //使用json的转换工具将对象转换成json格式字符串再返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick10")
    @ResponseBody
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("张三");
        user.setAge(99);
        return user;
    }

    /**
     * ----------获取参数-------------
     */
    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(String username, int age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(User user) throws IOException {
        System.out.println(user);
        System.out.println();
    }

//    http://localhost:8080/demo3/user/quick13?strs=aaa&strs=bbb&strs=ccc
    @RequestMapping("/quick13")
    @ResponseBody
    public void save13(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping("/quick14")
    @ResponseBody
    public void save14(VO vo) throws IOException {
        System.out.println(vo);
    }

    @RequestMapping("/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }


    @RequestMapping("/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "itcast") String username) throws IOException {
        System.out.println(username);
    }

//  http://localhost:8080/demo3/user/quick17/zhangsan
    @RequestMapping("/quick17/{username}")
    @ResponseBody
    public void save17(@PathVariable(value = "username") String username) throws IOException {
        System.out.println(username);
    }

//    自定义类型转换器
//    http://localhost:8080/demo3/user/quick18?date=2018-01-01   ×
//    http://localhost:8080/demo3/user/quick18?date=2018/12/12   √
    @RequestMapping("/quick18")
    @ResponseBody
    public void save18(Date date) throws IOException {
        System.out.println(date);
    }

    @RequestMapping("/quick19")
    @ResponseBody
    public void save19(@RequestHeader(value = "User-Agent", required = false) String headerValue) throws IOException {
        System.out.println(headerValue);
    }

    @RequestMapping("/quick20")
    @ResponseBody
    public void save20(@CookieValue(value = "JSESSIONID", required = false) String cookieValue) throws IOException {
        System.out.println(cookieValue);
    }


    //单文件上传
    //会替换同名文件
    @RequestMapping("/quick21")
    @ResponseBody
    public void save21(String username, MultipartFile multipartFile) throws IOException {
        //获得文件名
        String originalFilename = multipartFile.getOriginalFilename();
//        保存文件
        multipartFile.transferTo(new File("D:\\Users\\王景辉\\Desktop\\新建文件夹\\" + originalFilename));

        System.out.println(username);
        System.out.println(multipartFile);
    }

    //多文件上传
    @RequestMapping("/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile[] multipartFile) throws IOException {
        for (MultipartFile file : multipartFile) {
            String originalFilename = file.getOriginalFilename();
            System.out.println(originalFilename);
            file.transferTo(new File("D:\\Users\\王景辉\\Desktop\\新建文件夹\\" + originalFilename));
        }
        System.out.println(username);
    }
}
