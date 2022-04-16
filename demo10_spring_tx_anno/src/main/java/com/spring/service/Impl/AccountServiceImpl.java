package com.spring.service.Impl;

import com.spring.dao.AccountDao;
import com.spring.dao.Impl.AccountDaoImpl;
import com.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        //出现异常
//        int i = 1 / 0;
        accountDao.in(inMan, money);
    }

    @Transactional(isolation = Isolation.DEFAULT)
    public void save() {}
}
