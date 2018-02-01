package com.bbs.dao;


import java.util.List;

import com.bbs.article.Article;
import com.bbs.pagebean.PageBean;

public interface IDB {
	//��ѯ
	public PageBean<Article> list(PageBean<Article> pageBean);
	
	//��ѯ����������������
	public List<Article> deepList(int rootid);
	
	//ɾ��
	public List<Article> delete(int id, int pid);
	
	//�ظ�
	public void reply(int pid, int rootid, String title, String cont);
	
	//����
	public void post(String title, String cont);
	
	//�õ���Ӧid������
	public Article getArticle(int id);
	
	//�������
	public void modify(int id, String title, String cont);
	
	

}
