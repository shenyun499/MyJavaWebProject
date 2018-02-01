package com.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.article.Article;
import com.bbs.service.ArticleService;
import com.bbs.service.IArticleService;

/**
 * 
 * @author 黄智学
 *功能:删除帖子
 */
@Controller
public class ArticleControllerDelete {
	
	IArticleService articlep = new ArticleService();

	@RequestMapping(value="/delete.do")
	public String delete(Article article) {
		if (article.getId() != 0) {
			articlep.delete(article);
			return "delete";
		}
		return "redirect:articleList.do";
	}
}
