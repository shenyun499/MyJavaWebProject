package com.bbs.service;

import java.util.List;

import com.bbs.article.Article;
import com.bbs.dao.DB;
import com.bbs.dao.IDB;
import com.bbs.pagebean.PageBean;

public class ArticleService implements IArticleService{
	IDB db = new DB();

	//չʾ����
	@Override
	public PageBean<Article> list(PageBean<Article> pageBean) {
		return db.list(pageBean);
	}
	
	//��ϸչʾ����
	@Override
	public List<Article> deepList(int rootid) {
		return db.deepList(rootid);
	}
	
	//ɾ������
	@Override
	public void delete(Article article) {
		
		
		int id = article.getId();
		int pid = article.getPid();
		boolean isLeaf = article.getIsLeaf();
		System.out.println("����"+id+" "+pid+" "+isLeaf);
		if (!isLeaf) {
			List<Article> list = db.delete(id, pid);
			for (Article ar : list) {
				article = ar;
				delete(article);
			}
		} else {
			db.delete(id, pid);
		}
	}
	
	//�ظ�����
	@Override
	public void reply(Article article) {
		int pid = article.getPid();
		int rootid = article.getRootid();
		String title = article.getTitle();
		String cont = article.getCont();
		db.reply(pid, rootid, title, cont);
	}

	//����������
	@Override
	public void post(Article article) {
		String title = article.getTitle();
		String cont = article.getCont();
		db.post(title,cont);
		
	}
	
	//�õ�id�����article
	@Override
	public Article getArticle(int id) {
		return db.getArticle(id);
	}

	@Override
	public void modify(Article article) {
		int id = article.getId();
		String title = article.getTitle();
		String cont = article.getCont();
		db.modify(id, title, cont);
		
	}
	
}
