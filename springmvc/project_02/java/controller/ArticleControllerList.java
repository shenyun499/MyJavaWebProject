package com.bbs.controller;
/**
 * 
 *����:չʾ���е�����
 */

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.article.Article;
import com.bbs.pagebean.PageBean;
import com.bbs.service.ArticleService;
import com.bbs.service.IArticleService;

@Controller
public class ArticleControllerList {
	
	IArticleService article = new ArticleService();
	
	//��ʼҳ��
	@RequestMapping(value="/articleList.do")
	public String list(Model model) {
		int currentPage = 1;
		return this.setCurrentPage(currentPage,model);
	}
	
	//�õ���ҳ
	@RequestMapping(value="/firstPage.do")
	public String firstPage(int currentPage, Model model) {
		return this.setCurrentPage(currentPage,model);
	}
	
	//�õ���һҳ
	@RequestMapping(value="/nextPage.do")
	public String nextPage(int currentPage, Model model) {
		return setCurrentPage(currentPage,model);
	}
		
	//�õ���һҳ
	@RequestMapping(value="/previousPage.do")
	public String previousPage(int currentPage, Model model) {
		return setCurrentPage(currentPage,model);
	}
			
	//�õ�βҳ
	@RequestMapping(value="/lastPage.do")
	public String lastPage(int currentPage, Model model) {
		return setCurrentPage(currentPage,model);
	}		
			

	//���õ�ǰҳ
	public String setCurrentPage(int currentPage, Model model) {
		PageBean<Article> pageBean = new PageBean<Article>();
		pageBean.setPageSize(2);
		if (currentPage <= 0) {
			currentPage = 1;
			pageBean.setCurrentPage(currentPage);
		} else {
			pageBean.setCurrentPage(currentPage);
		}
		
		pageBean = article.list(pageBean);
		model.addAttribute("pageBean", pageBean);
		return "articleList";
	}
	
	//ת������ϸչʾҳ����ȥ
		@RequestMapping(value="/articleDetail.do")
		public String articleDetailFlat(int rootid, Model model) {
			if (rootid != 0) {
				List<Article> list = null; 
				list = article.deepList(rootid);
				model.addAttribute("list",list);
				return "articleDetail";
			} else {
				return "redirect:articleList.do";
			}
		}
}
