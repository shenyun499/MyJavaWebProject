package com.base.demo.user;

public class User {
	/**
	 * �û���
	 */
	private String username;
	/**
	 * �û��꼶
	 */
	private String grade;
	
	/**
	 * �û�ѧ��
	 */
	private String number;
	/**
	 * �û��绰
	 */
	private String phone;
	/**
	 * �û�����
	 */
	private String password;
	
	//��װ
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
