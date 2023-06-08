package com.atguigu.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.boot.bean.Car;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hanle01() {
		return "Hello,Spring Boot 2!" + "你好";
	}
	

	
    @Autowired
    Car car;
    @RequestMapping("/car")
    public Car car(){
        return car;
    }

}
