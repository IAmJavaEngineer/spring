package com.spring.service.Impl;

import com.spring.dao.AccountDao;
import com.spring.dao.Impl.AccountDaoImpl;
import com.spring.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        //出现异常
        int i = 1 / 0;
        accountDao.in(inMan, money);
    }
}
