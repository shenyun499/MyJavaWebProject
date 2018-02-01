package com.bbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBF {
	
	//���һ������
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs","root","1104428690A");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	//1��û��sql��䣬�õ�һ��statement������
	public static Statement getStmt(Connection con) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	//2����sql��䣬�õ�һ��statement������
		public static PreparedStatement getStmt(Connection con, String sql) {
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return stmt;
		}
		
	//1��û��sql��䣬�õ������
	public static ResultSet executeQuery(PreparedStatement stmt) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//2����sql��䣬�õ������
	public static ResultSet executeQuery(Statement stmt, String sql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//1����sql����ɾ�������룬����
	public static void executeUpdate(Statement stmt, String sql) {
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//1��û��sql���ɾ�������룬����
		public static void executeUpdate(PreparedStatement pstmt) {
			try {
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	//�رո�������
		public static void close(Connection con) {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			con = null;
		}
		
		public static void close(PreparedStatement pstmt) {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			pstmt = null;
		}
		
		public static void close(Statement stmt) {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			stmt = null;
		}
		
		public static void close(ResultSet rs) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			rs = null;
		}

}
