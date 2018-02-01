package com.bbs.service;

import java.util.List;

import com.bbs.article.Article;
import com.bbs.pagebean.PageBean;

public interface IArticleService {
	//获得这个对象
	public PageBean<Article> list(PageBean<Article> pageBean);
	
	//详细展示子贴
	public List<Article> deepList(int rootid);
	
	//删除帖子
	public void delete(Article article);
	
	//回复帖子
	public void reply(Article article);
	
	//发表新帖
	public void post(Article article);
	
	//得到对应id的对象
	public Article getArticle(int id);
	
	//更新帖子
	public void modify(Article article);
}
