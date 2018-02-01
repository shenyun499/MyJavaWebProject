package com.base.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.base.connection.mysql.Mysql;
import com.base.demo.user.User;
import com.mysql.jdbc.Connection;

public class DatabaseLoginCheck implements IDatabaseLoginCheck {
	public User loginCheck(User user) {
		Connection connection = Mysql.getConnection();
		String username = user.getUsername();
		String password = user.getPassword();
		User user2 = new User();
		PreparedStatement psta = null;
		ResultSet sult = null;
		String sql1 = "select *from students_information where username='"+username+"' ";
		try {
			psta = connection.prepareStatement(sql1);
			sult = psta.executeQuery();

			if (sult.next()) {
				user2.setUsername(username);
				if (sult.getString(6).equals(password)) {
					user2.setPassword(password);
				} 
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				psta.close();
				connection.close();
				sult.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user2;
	}
}
