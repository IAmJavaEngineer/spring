package com.spring.dao;

public interface AccountDao {

    //支出方法
    public void out(String outMan, double money);

    //收入方法
    public void in(String inMan, double money);

}
