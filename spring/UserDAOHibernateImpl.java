package com.spring.demo1;
/**
 * UserDAOHibernateImplʵ��UserDAO
 * @author ����ѧ
 *
 */

public class UserDAOHibernateImpl implements UserDAO {
	private String name;
	@Override
	public void save() {
		System.out.println("UserDAOHibernateImplʵ��"+name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
