package com.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

//标志改类是Spring的核心配置类
@Configuration
//<context:component-scan base-package="com.spring"/>
@ComponentScan("com.spring")
//<import resource=""/>
@Import({DataSourceConfiguration.class})

public class SpringConfiguration {


}
