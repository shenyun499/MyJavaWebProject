package com.base.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.base.connection.mysql.Mysql;

public class DatabaseDelete implements IDatabaseDelete{
	public void delete(HttpSession session) {
		//MYSQLÉ¾³ýÓï¾ä
		String username =(String)session.getAttribute("username");
		String sql = "delete from students_information where username='"+username+"'";
		PreparedStatement psta = null;
		Connection connection = Mysql.getConnection();
		try {
			psta = connection.prepareStatement(sql);
			psta.executeUpdate();
		} catch (SQLException e) {
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
