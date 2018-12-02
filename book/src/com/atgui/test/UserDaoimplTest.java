package com.atgui.test;

import org.junit.Test;

import com.atgui.daoimpl.UserDaoimpl;
import com.atgui.pojo.User;

public class UserDaoimplTest {
	@Test
	public void test() {
		UserDaoimpl user = new UserDaoimpl();
		int i = user.saveUser(new User("aaa","123456","12345@qq.com"));
		System.out.println(i+"行受到影响");
	}
	@Test
	public void test1() {
		UserDaoimpl user = new UserDaoimpl();
		User user2 = user.queryUserByUsername("aaa");
		System.out.println(user2);
	}
	
	@Test
	public void test2() {
		UserDaoimpl user2 = new UserDaoimpl();
		User user = user2.queryUserByUsernameAndPassword("aaa", "1256");
		System.out.println(user);
	}

}
