package com.spring.demo1;
/**
 * UserDAOImpl类实现UserDAO接口
 * @author 黄智学
 *
 */

public class UserDAOImpl implements UserDAO {
	@Override
	public void save() {
		System.out.println("UserDAOImpl实现");
	}
}
