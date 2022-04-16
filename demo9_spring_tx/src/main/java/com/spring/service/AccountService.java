package com.spring.service;

import com.spring.dao.AccountDao;
import com.spring.dao.Impl.AccountDaoImpl;

public interface AccountService {

    public void transfer(String outMan, String inMan, double money);

}
