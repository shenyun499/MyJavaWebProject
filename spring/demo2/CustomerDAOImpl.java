package com.spring.demo2;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void save() {
		System.out.println("�庯��������");
	}
	
	/**
	 * �������ڿ�ʼ
	 */
	public void setUp() {
		System.out.println("�������ڿ�ʼ");
	}
	
	/**
	 * �������ڽ���
	 */
	public void destroy() {
		System.out.println("�������ڽ���");
	}

}
