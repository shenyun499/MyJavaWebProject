package com.base.demo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.base.connection.mysql.Mysql;
import com.base.demo.user.User;
import com.mysql.jdbc.Connection;

public class DatabaseAdd implements IDatabaseAdd{
	
	public void add(User user){
		//MYSQL������
		String sql = "insert into students_information (username,grade,number,phone,password) value(?,?,?,?,?)";
		PreparedStatement psta = null;
		/*
		 * ������ݿ�����Ӷ���
		 */
		Connection connection = Mysql.getConnection();
		try {
			psta = connection.prepareStatement(sql);
			psta.setString(1, user.getUsername());
			psta.setString(2, user.getGrade());
			psta.setString(3, user.getNumber());
			psta.setString(4, user.getPhone());
			psta.setString(5, user.getPassword());
			//д������
			psta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				psta.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
