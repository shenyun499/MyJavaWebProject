/**
 * @author 黄智学
 * 作用：注解实现登陆模块的功能
 * 
 */
package com.base.demo.controller;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.demo.service.IUserService;
import com.base.demo.service.UserService;
import com.base.demo.user.User;

@Controller
public class LoginController {
	IUserService userService = new 	UserService();
	
	//返回到登陆页面
	@RequestMapping(value="/login.do")
	public String toLogin() {
		return "login";
	}
	
	//返回到注册页面
		@RequestMapping(value="/register.do")
		public String toRegister() {
			return "register";
		}
	
	//检查用户输入是否为空
	@RequestMapping(value="/index.do")
	public String login(HttpSession session, User user) throws SQLException {
		if (user.getUsername() == null || user.getPassword() == null) {
			return "redirect:login.do";//跳回到登陆页面
		} else if (user.getUsername().equals("") || user.getPassword().equals("")) {
			return "login_false";
		} else {
			user = userService.loginSuccess(user);
				if (user.getUsername() == null) {//用户名不存在
					return "login_false2";
				} else if (user.getPassword() == null) {//密码错误
					return "login_false3";
				} else {
					session.setAttribute("username", user.getUsername());
					return "login_success";
				}
			}
		}
}
