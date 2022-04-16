package com.spring.proxy.jdk;

public class Target implements TargetIterface{
    @Override
    public void save() {
        System.out.println("save running....");
    }
}
