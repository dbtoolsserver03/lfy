package com.atguigu.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.bean.yml.Person;

import lombok.extern.slf4j.Slf4j;
@Slf4j
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
    	log.info("请求进来了....");
    	
    	User u = new User();
    	u.setAge(1);
    	
        return car;
    }

    
    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person(){

        String userName = person.getUserName();
        System.out.println(userName);
        return person;
    }
    
    
}
