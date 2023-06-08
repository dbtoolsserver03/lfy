package com.atguigu.boot.bean.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;

import ch.qos.logback.core.hook.DefaultShutdownHook;

/**
 * 1.配置类里面使用@Bean标在方法上给容器注册组件，默认也是单补全的。
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods:代理Bean的方法 默认为true
 *    Full(true),Lite轻量(false)
 *      Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *   ○ 最佳实战
	    ■ 配置 类组件之间无依赖关系用Lite模式加速容器启动过程，减少判断
	    ■ 配置类组件之间有依赖关系，方法会被调用得到之前单实例组件，用Full模式
	    
	    
 * 4、@Import({User.class, DefaultShutdownHook.class})
 *      给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 *
 *
 *
 */

// 写在容器类的组件里就可以.比如@Component、@Controller、@Service、@Repository
@Import({ User.class, DefaultShutdownHook.class })
@Configuration(proxyBeanMethods = false) //告诉SPRINGBOOT 这是一个配置类 == 配置文件beans.XML
public class MyConfig {

	/**
	 * 外部无论对配置类中的这个组件注册方法调用多少次，获取的伏特加不急之前注册容器中的单实例对象
	 * 
	 * */

	@ConditionalOnBean(name = "tom")
	@Bean //给容器中添加组件，以方法名作为组件的id,返回类型就是组件类型，反回的值，就是组件在容器中的实例
	public User user01() {
		User zhangsan = new User("zhangsan", 18);
		zhangsan.setPet(tomcatPet());
		return zhangsan;
	}

	//@Bean("tom")
	public Pet tomcatPet() {
		return new Pet("tom");
	}

}
