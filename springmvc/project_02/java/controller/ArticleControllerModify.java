package com.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.article.Article;
import com.bbs.service.ArticleService;
import com.bbs.service.IArticleService;

/**
 * 
 * @author 黄智学
 *功能:更新帖子内容
 *
 */
@Controller
public class ArticleControllerModify {
	
	IArticleService article = new ArticleService();

	
	@RequestMapping(value="/modify.do")
	public String modify(String cont, Article art, Integer id, Model model, String sign) {
		if (id != null && sign != null) {
			article.modify(art);
			return "modifyFinish";
		} else if (id != null && sign == null) {
			Article ar = null;
			ar = article.getArticle(id);
			model.addAttribute("article",ar);
			return "modify";
		}
		return "redirect:articleList.do";
	}

}
