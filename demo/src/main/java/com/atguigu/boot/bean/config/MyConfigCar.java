package com.atguigu.boot.bean.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.atguigu.boot.bean.Car;


// 让properties生效
//2、@EnableConfigurationProperties + @ConfigurationProperties
//3、@Component + @ConfigurationProperties

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(Car.class)
//1、开启Car配置绑定功能   只能和核心配置文件绑定application.properties
//2、把这个Car这个组件自动注册到容器中
public class MyConfigCar {
}
