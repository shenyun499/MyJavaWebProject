package com.bbs.service;

import java.util.List;

import com.bbs.article.Article;
import com.bbs.pagebean.PageBean;

public interface IArticleService {
	//����������
	public PageBean<Article> list(PageBean<Article> pageBean);
	
	//��ϸչʾ����
	public List<Article> deepList(int rootid);
	
	//ɾ������
	public void delete(Article article);
	
	//�ظ�����
	public void reply(Article article);
	
	//��������
	public void post(Article article);
	
	//�õ���Ӧid�Ķ���
	public Article getArticle(int id);
	
	//��������
	public void modify(Article article);
}
