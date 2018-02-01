/**
 * @author ����ѧ
 * ���ã�ע��ʵ�ֵ�½ģ��Ĺ���
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
	
	//���ص���½ҳ��
	@RequestMapping(value="/login.do")
	public String toLogin() {
		return "login";
	}
	
	//���ص�ע��ҳ��
		@RequestMapping(value="/register.do")
		public String toRegister() {
			return "register";
		}
	
	//����û������Ƿ�Ϊ��
	@RequestMapping(value="/index.do")
	public String login(HttpSession session, User user) throws SQLException {
		if (user.getUsername() == null || user.getPassword() == null) {
			return "redirect:login.do";//���ص���½ҳ��
		} else if (user.getUsername().equals("") || user.getPassword().equals("")) {
			return "login_false";
		} else {
			user = userService.loginSuccess(user);
				if (user.getUsername() == null) {//�û���������
					return "login_false2";
				} else if (user.getPassword() == null) {//�������
					return "login_false3";
				} else {
					session.setAttribute("username", user.getUsername());
					return "login_success";
				}
			}
		}
}
