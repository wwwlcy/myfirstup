package com.atgui.service.impl;

import com.atgui.dao.UserDao;
import com.atgui.daoimpl.UserDaoimpl;
import com.atgui.pojo.User;
public class ServiceImpl implements Service {

	UserDao user1 = new UserDaoimpl();
	@Override
	public User Login(User user) {
		return user1.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	@Override
	public int regist(User user) {
		 int i = user1.saveUser(user);
		 return i;

	}

	/**
	 * 如果数据库不存在，返回true，如果存在，返回false
	 */
	@Override
	public boolean exist(String username) {
		 if( user1.queryUserByUsername(username)==null) {
			 return true;
		 }else {
			 return false;
		 }

	}

}
