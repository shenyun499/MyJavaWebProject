package com.base.demo.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.demo.service.IUserService;
import com.base.demo.service.UserService;
import com.base.demo.user.User;
@Controller
public class DatabaseAddController {
	IUserService userService = new UserService();
	//зЂВс
		@RequestMapping(value="/register2.do")
		public String add(User user) throws SQLException {
			userService.add(user);
			return "register_finish";
		}
}
