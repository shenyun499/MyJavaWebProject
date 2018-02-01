package com.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.article.Article;
import com.bbs.service.ArticleService;
import com.bbs.service.IArticleService;

/**
 * 
 * @author 黄智学
 *功能:发表新的帖子
 */
@Controller
public class ArticleControllerPost {
	
	IArticleService article = new ArticleService();

	
	@RequestMapping(value="/post.do")
	public String post(Article ar, String sign) {
		if (ar.getTitle() != null && sign != null) {
			article.post(ar);
			return "postFinish";
		} else if (sign != null){
			return "post";
		}
		return "redirect:articleList.do";
	}
	

}
