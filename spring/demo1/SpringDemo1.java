package com.spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ����
 * @author ����ѧ
 *
 */
public class SpringDemo1 {
	@Test
	/**
	 * ��ͳ��ʽ����
	 */
	public void demo1() {
		UserDAO userService = new UserDAOHibernateImpl();
		//��Ҫ����ת�Ͳſ��Ե���UserDAOHibernateImpl���������ã�û�в���DI����ע��
		UserDAOHibernateImpl user = (UserDAOHibernateImpl)userService;
		user.setName("����");
		userService.save();
	}
	
	@SuppressWarnings("resource")
	@Test
	/**
	 * ����ģʽ����
	 */
	public void demo2() {
		//ʵ����xml�ļ�����
		ApplicationContext applicationContext = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		//ͨ��id���ʵ��
		UserDAO userDAO = (UserDAO)applicationContext.getBean("userDAO");
		userDAO.save();
	}
}
