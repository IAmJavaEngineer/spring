package com.wangjinghui.factory;

import com.wangjinghui.dao.Impl.UserDaoImpl;
import com.wangjinghui.dao.UserDao;

public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
