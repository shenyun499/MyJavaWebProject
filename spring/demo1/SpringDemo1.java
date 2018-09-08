package com.spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试
 * @author 黄智学
 *
 */
public class SpringDemo1 {
	@Test
	/**
	 * 传统方式调用
	 */
	public void demo1() {
		UserDAO userService = new UserDAOHibernateImpl();
		//需要向下转型才可以调用UserDAOHibernateImpl的属性设置，没有采用DI依赖注入
		UserDAOHibernateImpl user = (UserDAOHibernateImpl)userService;
		user.setName("张三");
		userService.save();
	}
	
	@SuppressWarnings("resource")
	@Test
	/**
	 * 工厂模式调用
	 */
	public void demo2() {
		//实现与xml文件链接
		ApplicationContext applicationContext = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		//通过id获得实例
		UserDAO userDAO = (UserDAO)applicationContext.getBean("userDAO");
		userDAO.save();
	}
}
