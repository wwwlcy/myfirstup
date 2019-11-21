package com.atgui.dao;

import com.atgui.pojo.User;

public interface UserDao {
	
	public int saveUser( User user );
	
	public User queryUserByUsername(String username);
	
	public User queryUserByUsernameAndPassword(String username,String password);

}
