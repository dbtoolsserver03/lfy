package com.atguigu.boot.bean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
/**
 * 1.配置类里面使用@Bean标在方法上给容器注册组件，默认也是单补全的。
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods:代理Bean的方法 默认为true
 *    Full(true),Lite轻量(false)
 * 
 * 
 */
@Configuration(proxyBeanMethods = true) //告诉SPRINGBOOT 这是一个配置类 == 配置文件beans.XML
public class MyConfig {

	
	/**
	 * 外部无认对配置类中的这个组件注册方法调用多少次，获取的伏特加不急之前注册容器中的单实例对象
	 * 
	 * */
	@Bean //给容器中添加组件，以方法名作为组件的id,返回类型就是组件类型，反回的值，就是组件在容器中的实例
	public User user01() {
		return new User("zhangsan", 18);
	}
	
	@Bean("tom")
	public Pet tomcatPet() {
		return new Pet("tom");
	}

}
