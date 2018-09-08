package com.spring.demo2;
/**
 * 测试类
 * @author 黄智学
 *
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {
	@SuppressWarnings("resource")
	@Test
	/**
	 * 工厂类测试
	 */
	public void test() {
		//解析XML文件
		ApplicationContext applicatinContext = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		//反射
		CustomerDAO customerDAO = (CustomerDAO)applicatinContext.getBean("CustomerDAO");
		
		customerDAO.save();
		
		//关闭工厂，销毁对象
		ClassPathXmlApplicationContext applicatinContext2 = (ClassPathXmlApplicationContext)applicatinContext;
		applicatinContext2.close();
	}

}
