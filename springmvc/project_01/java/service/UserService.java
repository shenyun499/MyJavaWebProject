/**
 * 业务处理类
 * 
 */
package com.base.demo.service;


import javax.servlet.http.HttpSession;

import com.base.demo.dao.DatabaseAdd;
import com.base.demo.dao.DatabaseDelete;
import com.base.demo.dao.DatabaseList;
import com.base.demo.dao.DatabaseLoginCheck;
import com.base.demo.dao.IDatabaseAdd;
import com.base.demo.dao.IDatabaseDelete;
import com.base.demo.dao.IDatabaseList;
import com.base.demo.dao.IDatabaseLoginCheck;
import com.base.demo.pagebean.PageBean;
import com.base.demo.user.User;

public class UserService implements IUserService{
	IDatabaseAdd add = new DatabaseAdd();
	IDatabaseDelete delete = new DatabaseDelete();
	IDatabaseList list = new DatabaseList();
	IDatabaseLoginCheck check = new DatabaseLoginCheck();
	//业务处理增添用户
	public void add(User user) {
		add.add(user);
	}
	
	//业务处理删除用户
	public void delete(HttpSession session) {
		delete.delete(session);
	}
	
	//业务处理查询成功
	public PageBean<User> list(PageBean<User> pagebean) {
		return list.list(pagebean);
	}
	
	//业务处理登陆成功
	public User loginSuccess(User user) {
		return check.loginCheck(user);
	}
}
