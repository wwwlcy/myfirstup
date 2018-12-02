package com.atgui.service.impl;

import com.atgui.pojo.User;

public interface Service {
	
	//登陆功能
	public User Login(User user);
	
	//注册功能
	public int regist(User user);
	
	//判断用户名是否可以用
	public boolean exist(String username);

}
