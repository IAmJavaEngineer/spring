package com.wangjinghui.factory;

import com.wangjinghui.dao.Impl.UserDaoImpl;
import com.wangjinghui.dao.UserDao;

public class DynamicFactory {
    public UserDao getUser() {
        return new UserDaoImpl();
    }
}
