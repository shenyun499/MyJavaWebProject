package com.spring.demo2;
/**
 * ������
 * @author ����ѧ
 *
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {
	@SuppressWarnings("resource")
	@Test
	/**
	 * ���������
	 */
	public void test() {
		//����XML�ļ�
		ApplicationContext applicatinContext = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		//����
		CustomerDAO customerDAO = (CustomerDAO)applicatinContext.getBean("CustomerDAO");
		
		customerDAO.save();
		
		//�رչ��������ٶ���
		ClassPathXmlApplicationContext applicatinContext2 = (ClassPathXmlApplicationContext)applicatinContext;
		applicatinContext2.close();
	}

}
