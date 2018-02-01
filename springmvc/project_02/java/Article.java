package com.bbs.article;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author 黄智学
 * 功能：创建一个帖子类
 *
 */
public class Article {
	/*
	 * 帖子id
	 */
	private int id;
	
	/*
	 * 父帖pid
	 */
	private int pid;
	
	/*
	 * 帖子种类rootid
	 */
	private int rootid;
	
	/*
	 * 帖子主题
	 */
	private String title;
	
	/*
	 * 帖子内容
	 */
	private String cont;
	
	/*
	 * 判断是否是结点帖子
	 */
	
	private Date pdate;
	
	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	private boolean isLeaf;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getRootid() {
		return rootid;
	}

	public void setRootid(int rootid) {
		this.rootid = rootid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public boolean getIsLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	} 
	
	public void initArtile(ResultSet rs) {
			try {
				this.setId(rs.getInt("id"));
				this.setPid(rs.getInt("pid"));
				this.setRootid(rs.getInt("rootid"));
				this.setTitle(rs.getString("title"));
				this.setCont(rs.getString("cont"));
				this.setLeaf(rs.getInt("isleaf") == 0);
				this.setPdate(rs.getDate("pdate"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", pid=" + pid + ", rootid=" + rootid + ", title=" + title + ", cont=" + cont
				+ ", pdate=" + pdate + ", isLeaf=" + isLeaf + "]";
	}
	

}
