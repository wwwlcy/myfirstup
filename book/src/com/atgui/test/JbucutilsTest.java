package com.atgui.test;

import java.sql.Connection;

import org.junit.Test;

import com.atgui.utils.Jdbcutils;

public class JbucutilsTest {
	
	@Test
	public void test() {
		Connection connection = Jdbcutils.getConnection();
		System.out.println(connection);
	}

}
