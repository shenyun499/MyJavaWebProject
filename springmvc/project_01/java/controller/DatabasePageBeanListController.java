package com.base.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.demo.pagebean.PageBean;
import com.base.demo.service.IUserService;
import com.base.demo.service.UserService;
import com.base.demo.user.User;

@Controller
public class DatabasePageBeanListController {
	IUserService userService = new UserService();
	//ת������ҳ
	@RequestMapping(value="/firstPage.do")
	public String firstPage(int currentPage, Model model) {
		return this.getCurrentPage(currentPage, model);
	}
	
	//ת������һҳ
	@RequestMapping(value="/previousPage.do")
	public String previousPage(int currentPage, Model model) {
		return this.getCurrentPage(currentPage, model);
	}
	
	//ת������һҳ
	@RequestMapping(value="/nextPage.do")
	public String nextPage(int currentPage, Model model) {
		return this.getCurrentPage(currentPage, model);
	}
	
	//ת����βҳ
	@RequestMapping(value="/lastPage.do")
	public String lastPage(int currentPage, Model model) {
		return this.getCurrentPage(currentPage, model);
	}
	
	@RequestMapping(value="/database_list.do")
	public String databaseList(Model model) {
		int currentPage = 1;
		return this.getCurrentPage(currentPage, model);
	}

	//�õ���ǰҳ
	private String getCurrentPage(int currentPage, Model model) {
		int pageSize = 2;
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		pageBean = userService.list(pageBean);
		model.addAttribute("pageBean", pageBean);
		return "list";
	}
}
