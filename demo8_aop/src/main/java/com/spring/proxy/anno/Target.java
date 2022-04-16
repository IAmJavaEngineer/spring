package com.spring.proxy.anno;

import org.springframework.stereotype.Component;

@Component
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running....");
//        int i = 1 / 0;
    }
}

