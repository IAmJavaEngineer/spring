package com.spring.test;

import com.spring.proxy.aop.TargetInterface;
import com.spring.proxy.cglib.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {
    @Autowired
    private TargetInterface targetInterface;

    @Test
    public void test1() {
        targetInterface.save();
    }
}
