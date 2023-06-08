package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.bean.config.MyConfig;

import ch.qos.logback.core.hook.DefaultShutdownHook;

@SpringBootApplication(scanBasePackages = "com.atguigu")
public class MainApplication {

	public static void main(String[] args) {

		
		// 1.返回IOC容器
		ConfigurableApplicationContext run= SpringApplication.run(MainApplication.class, args);
		
		// 2.查看容器里面的组件
		String[] names = run.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		// 3.从容器中获取组件
		Pet tom01 = run.getBean(Pet.class);
		Pet tom02 = run.getBean(Pet.class);
		System.out.println("组件="+(tom01==tom02));
		
		
		// 4. com.atguigu.boot.bean.config.MyConfig$$SpringCGLIB$$0@7af00bdd
		MyConfig bean = run.getBean(MyConfig.class);
		System.out.println(bean);
		
		
		// 如果@Configuration(proxyBeanMethods = true) 代理对象调用方法。SpringBoot总会检查这个组件是否在容器中。
		// 保持组件单实例
		User user = bean.user01();
		User user1 = bean.user01();
		System.out.println("当proxyBeanMethods为TRUE时："+(user==user1));//true
		//System.out.println("当proxyBeanMethods为FALSE时："+(user==user1));//false
		
		User user01 = run.getBean("user01",User.class);
		Pet tom = run.getBean("tom",Pet.class);
		
		System.out.println("当proxyBeanMethods为TRUE时： 用户的宠物:" + (user01.getPet() == tom));//true
		//System.out.println("当proxyBeanMethods为FALSE时：  用户的宠物:" + (user01.getPet() == tom));//false
	
		// 5.获取组件
		System.out.println("=====");
		for (String name : run.getBeanNamesForType(User.class)) {
			System.out.println(name);
		}
		System.out.println(run.getBean(DefaultShutdownHook.class));
	}

}
