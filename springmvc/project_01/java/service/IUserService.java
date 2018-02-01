package com.base.demo.service;

import javax.servlet.http.HttpSession;

import com.base.demo.pagebean.PageBean;
import com.base.demo.user.User;

public interface IUserService {
	public void add(User user);
	public void delete(HttpSession session);
	public PageBean<User> list(PageBean<User> pagebean);
	public User loginSuccess(User user);

}
