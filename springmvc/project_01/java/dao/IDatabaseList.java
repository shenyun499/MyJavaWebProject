package com.base.demo.dao;

import com.base.demo.pagebean.PageBean;
import com.base.demo.user.User;

public interface IDatabaseList {
	public PageBean<User> list(PageBean<User> pageBean);
		
}
