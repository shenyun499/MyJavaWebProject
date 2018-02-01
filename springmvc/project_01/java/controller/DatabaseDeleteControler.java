package com.base.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.demo.service.IUserService;
import com.base.demo.service.UserService;

@Controller
public class DatabaseDeleteControler {
	IUserService userService = new UserService();
	@RequestMapping(value="/delete.do") 
	public String delete(HttpSession session) {
		userService.delete(session);
		return "delete_success";
		
	}
	

}
