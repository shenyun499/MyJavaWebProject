package com.bbs.dao;


import java.util.List;

import com.bbs.article.Article;
import com.bbs.pagebean.PageBean;

public interface IDB {
	//查询
	public PageBean<Article> list(PageBean<Article> pageBean);
	
	//查询单个贴的所有子帖
	public List<Article> deepList(int rootid);
	
	//删除
	public List<Article> delete(int id, int pid);
	
	//回复
	public void reply(int pid, int rootid, String title, String cont);
	
	//插入
	public void post(String title, String cont);
	
	//得到对应id的帖子
	public Article getArticle(int id);
	
	//插入更新
	public void modify(int id, String title, String cont);
	
	

}
