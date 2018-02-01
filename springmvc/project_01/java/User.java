package com.base.demo.user;

public class User {
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户年级
	 */
	private String grade;
	
	/**
	 * 用户学号
	 */
	private String number;
	/**
	 * 用户电话
	 */
	private String phone;
	/**
	 * 用户密码
	 */
	private String password;
	
	//封装
	public void setUsername(String username) {
		this.username = username;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public String getGrade() {
		return grade;
	}
	public String getNumber() {
		return number;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	public String getPhone() {
		return phone;
	}
	public String getPassword() {
		return password;
	}
	
	
}
