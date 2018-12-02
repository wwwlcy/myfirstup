package com.atgui.test;

import org.junit.Test;

import com.atgui.pojo.User;
import com.atgui.service.impl.ServiceImpl;

public class ServiceTest {
	ServiceImpl se = new ServiceImpl();
	@Test
	public void testLogin() {
		User user = se.Login(new User("aaa", "123456", null));
		if(user == null) {
			System.out.println("鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒");
		}else {
			System.out.println("鐧婚檰鎴愬姛");
		}
	}
	@Test
	public void testregist() {
		int regist = se.regist(new User("的是1", "123456", null));
		if(regist !=-1) {
			System.out.println("娉ㄥ唽鎴愬姛");
		}else {
			System.out.println("娉ㄥ唽澶辫触");
		}
	}
	@Test
	public void testexist() {
		boolean exist = se.exist("aaa");
		if(exist) {
			System.out.println("鐢ㄦ埛鍚嶅彲鐢�");
		}else {
			System.out.println("鐢ㄦ埛鍚嶄笉鍙敤");
		}
	}

}
