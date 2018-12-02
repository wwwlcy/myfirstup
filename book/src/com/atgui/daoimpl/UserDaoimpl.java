package com.atgui.daoimpl;

import com.atgui.dao.UserDao;
import com.atgui.pojo.User;

public class UserDaoimpl extends BaseDaoImpl<User> implements UserDao {

	/**
	 * 像数据库中插入User
	 *  
	 * 如果返回值为1  则插入成功
	 * 如果返回值为-1 则插入失败
	 */
	@Override
	public int saveUser(User user) {
		String sql ="INSERT INTO `book`.`user`"
	           +" (  `username`,`password`, `email`)"
	       +"VALUES (?, ?,?);";
		
		return update(sql, user.getUsername(),user.getPassword(),user.getEamil());
	}
	
	/**
	 * 通过用户名查找用户，如果返回值不为null 说明数据库中存在这个用户
	 * 如果返回值为null 说明没有该用户
	 */
	@Override
	public User queryUserByUsername(String username) {
		String sql="select `id`, `username`,`password`, `email` FROM `user` where username = ?";
		return QueryForOne(sql, username);
		
	}
	
		/**
		 * 通过用户名和密码查询用户
		 * 如果返回值为null  则说明用户名或者密码错误
		 * 如果不为null 则说明用户名和密码都正确
		 */
	@Override
	public User queryUserByUsernameAndPassword(String username, String password) {
		String sql="select `id`, `username`,`password`, `email` FROM `user` where username = ? and password = ?";
		return QueryForOne(sql, username,password);
	}

}
