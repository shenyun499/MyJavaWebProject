package com.bbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.article.Article;
import com.bbs.service.ArticleService;
import com.bbs.service.IArticleService;

/**
 * 
 * @author 黄智学
 *功能:回复帖子
 */
@Controller
public class ArticleControllerReply {
	
	IArticleService article = new ArticleService();
	
	@RequestMapping(value="/reply.do")
	public String reply(Integer id, Integer rootid, HttpSession session, Model model) {		
		if (id != null && rootid != null) {
		
			model.addAttribute("id", id);
			model.addAttribute("rootid",rootid);
			return "reply";
		}
		return "redirect:articleList.do";
		
	}
	
	@RequestMapping(value="/replyFinish.do")
	public String replyFinally(Article ar) {
		if (ar.getTitle() != null) {
			System.out.println(ar.getCont());
			article.reply(ar);
			return "replyFinish";
		}
		return "redirect:articleList.do";
	}

}
