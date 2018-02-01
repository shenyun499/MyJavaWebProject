/**
 * ҵ������
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
	//ҵ���������û�
	public void add(User user) {
		add.add(user);
	}
	
	//ҵ����ɾ���û�
	public void delete(HttpSession session) {
		delete.delete(session);
	}
	
	//ҵ�����ѯ�ɹ�
	public PageBean<User> list(PageBean<User> pagebean) {
		return list.list(pagebean);
	}
	
	//ҵ�����½�ɹ�
	public User loginSuccess(User user) {
		return check.loginCheck(user);
	}
}
