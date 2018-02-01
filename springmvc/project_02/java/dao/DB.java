package com.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bbs.article.Article;
import com.bbs.pagebean.PageBean;

public class DB implements IDB {
	//��������ݿ�֮�������
	Connection con = null;

	//��ҳչ����������
	@SuppressWarnings("resource")
	@Override
	public PageBean<Article> list(PageBean<Article> pageBean) {
		con = DBF.getConnection();
		List<Article> list = new ArrayList<Article>();
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		pstmt = DBF.getStmt(con,"select *from article where pid=0 limit ?,?");
		try {
			stmt = DBF.getStmt(con);
			rs = DBF.executeQuery(stmt, "select count(*) from article where pid=0");
			
			//�õ��ܼ�¼�����������ҳ������
			if (rs.next()) {
				pageBean.setTotalRecord(rs.getInt(1));
				pageBean.setTotalPage(pageBean.getTotalRecord(), pageBean.getPageSize());
			}
			
			//���ҳ������ܼ�ҳ��������Ҫ�õ�ǰҳ�������ҳ��
			if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
				pageBean.setCurrentPage(pageBean.getTotalPage());
			}
			
			pstmt.setInt(1, (pageBean.getCurrentPage()-1)*pageBean.getPageSize());
			pstmt.setInt(2, pageBean.getPageSize());
			rs = DBF.executeQuery(pstmt);
			while (rs.next()) {
				Article ar = new Article();
				ar.initArtile(rs);
				list.add(ar);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBF.close(con);
			DBF.close(rs);
			DBF.close(pstmt);
			DBF.close(stmt);
		}
		pageBean.setResult(list);
		return pageBean;
	}
	
	//չʾ������Ӧ����������
	@Override
	public List<Article> deepList(int rootid) {
		con = DBF.getConnection();
		List<Article> list = new ArrayList<Article>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = DBF.executeQuery(stmt, "select *from article where rootid="+rootid);
			while (rs.next()) {
				Article article = new Article();
				article.initArtile(rs);
				list.add(article);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBF.close(con);
			DBF.close(rs);
			DBF.close(stmt);
		}
		return list;
	}
	
	//ɾ������
	@Override
	public List<Article> delete(int id, int pid) {
		con = DBF.getConnection();
		List<Article> list = new ArrayList<Article>();
		int count = 1;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = DBF.executeQuery(stmt,"select *from article where pid="+id);
			while(rs.next()) {
				Article article = new Article();
				article.initArtile(rs);
				list.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//ɾ��
		try {
			stmt = con.createStatement();
			DBF.executeUpdate(stmt, "delete from article where id="+id);
			rs = DBF.executeQuery(stmt,"select count(*) from article where pid="+pid);
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//���ɾ�������Ǹ��ڵ㣬��ĸ���isleaf=0
		if (count <= 0) {
			try {
				stmt = con.createStatement();
				DBF.executeUpdate(stmt, "update article set isleaf=0 where id="+pid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//�ر�����
		DBF.close(con);
		DBF.close(rs);
		DBF.close(stmt);
		return list;
	}

	//�ظ�����
	@Override
	public void reply(int pid, int rootid, String title, String cont) {
		Connection con = DBF.getConnection();
		PreparedStatement pstmt = null;
		Statement stmt = null;
		pstmt = DBF.getStmt(con,"insert into article values(null,?,?,?,?,now(),?)");
		stmt = DBF.getStmt(con);
		try {
			pstmt.setInt(1, pid);
			pstmt.setInt(2, rootid);
			pstmt.setString(3, title);
			pstmt.setString(4, cont);
			pstmt.setInt(5, 0);
			DBF.executeUpdate(pstmt);
			DBF.executeUpdate(stmt, "update article set isleaf=1 where id="+pid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBF.close(con);
			DBF.close(pstmt);
			DBF.close(stmt);
		}
		
		
	}

	@Override
	public void post(String title, String cont) {
		int rootid = 1;
		Connection con = DBF.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		
		try {
			stmt = DBF.getStmt(con);
			rs = DBF.executeQuery(stmt,"select *from article where pid=0");
			while (rs.next()) {
				if (rootid < rs.getInt("rootid")) {
					rootid = rs.getInt("rootid");
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		pstmt = DBF.getStmt(con,"insert into article values(null,?,?,?,?,now(),?)");
		try {
			pstmt.setInt(1, 0);
			pstmt.setInt(2, rootid+1);
			pstmt.setString(3, title);
			pstmt.setString(4, cont);
			pstmt.setInt(5, 0);
			DBF.executeUpdate(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBF.close(con);
			DBF.close(pstmt);
			DBF.close(stmt);
		}
		
	}

	@Override
	public void modify(int id, String title, String cont) {
		con = DBF.getConnection();
		PreparedStatement pstmt = null;
		pstmt = DBF.getStmt(con,"update article set title=?,cont=? where id="+id);
		try {
			pstmt.setString(1, title);
			pstmt.setString(2, cont);
			DBF.executeUpdate(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBF.close(con);
			DBF.close(pstmt);
		}
	}

	@Override
	public Article getArticle(int id) {
		con = DBF.getConnection();
		ResultSet rs = null;
		Statement stmt = null;
		Article article = null;
		try {
			stmt = DBF.getStmt(con);
			rs = DBF.executeQuery(stmt, "select *from article where id="+id);
			rs.next();
			article = new Article();
			article.initArtile(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBF.close(con);
			DBF.close(stmt);
			DBF.close(rs);
		}
		return article;
	}
}
