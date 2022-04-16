package com.spring.proxy.jdk;

public class Advice {

    public void before() {
        System.out.println("Advice的before方法");
    }
    public void afterReturning() {
        System.out.println("Advice的afterReturning方法");
    }
}
