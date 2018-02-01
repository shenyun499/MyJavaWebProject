package com.base.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.base.connection.mysql.Mysql;
import com.base.demo.pagebean.PageBean;
import com.base.demo.user.User;
import com.mysql.jdbc.Connection;

public class DatabaseList implements IDatabaseList{
	
	public PageBean<User> list(PageBean<User> pageBean) {
		/*
		 * 获得数据库的连接对象
		 */
		Connection connection = Mysql.getConnection();
		int pageSize = 2;
		List<User> user = new ArrayList<User>();
		String sql = "select *from students_information limit ?,?";
		String sql2 = "select *from students_information";
		PreparedStatement psta = null;
		ResultSet sult = null;
		
		if (pageBean.getCurrentPage() <= 0) {
			pageBean.setCurrentPage(1);
		}
		try {
			psta = connection.prepareStatement(sql);
			psta.setInt(1, (pageBean.getCurrentPage()-1)*pageSize);
			psta.setInt(2, 2);
			sult = psta.executeQuery();
			while (sult.next()) {
				User use = new User();
				use.setUsername(sult.getString("username"));
				use.setGrade(sult.getString("grade"));
				use.setNumber(sult.getString("number"));
				use.setPhone(sult.getString("phone"));
				use.setPassword(sult.getString("password"));
				user.add(use);
			}
			
			psta = connection.prepareStatement(sql2);
			sult = psta.executeQuery();
			while (sult.next()) {
				pageBean.setTotalRecord(sult.getInt(1));
				pageBean.setTotalPage(pageBean.getTotalRecord(), pageSize);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
			pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		pageBean.setResults(user);
		return pageBean;
	}

}
