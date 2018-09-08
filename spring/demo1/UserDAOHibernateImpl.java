package com.spring.demo1;
/**
 * UserDAOHibernateImpl实现UserDAO
 * @author 黄智学
 *
 */

public class UserDAOHibernateImpl implements UserDAO {
	private String name;
	@Override
	public void save() {
		System.out.println("UserDAOHibernateImpl实现"+name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
