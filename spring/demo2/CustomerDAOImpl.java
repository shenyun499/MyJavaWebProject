package com.spring.demo2;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void save() {
		System.out.println("体函数，内容");
	}
	
	/**
	 * 生命周期开始
	 */
	public void setUp() {
		System.out.println("生命周期开始");
	}
	
	/**
	 * 生命周期结束
	 */
	public void destroy() {
		System.out.println("生命周期结束");
	}

}
