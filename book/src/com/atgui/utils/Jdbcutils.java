package com.atgui.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Jdbcutils {

	private static ComboPooledDataSource conn = new ComboPooledDataSource("c3p0-config.xml");
	
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	// 获得数据库连接
	public static Connection getConnection() {
		Connection connection = threadLocal.get();
			try {
				if(connection == null) {
				connection = conn.getConnection();
				threadLocal.set(connection);
				connection.setAutoCommit(false);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
		return connection;
	}

	public static void commit() {
		Connection connection = threadLocal.get();
		if(connection !=null) {
			try {
				connection.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadLocal.remove();
		}
	}
	
	public static void rollBack() {
		Connection connection = threadLocal.get();
		if(connection != null) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadLocal.remove();
		}
	}
	
	// 关闭数据库连接   仅仅用于 com.atguigu.practice 一个包下面
	public static void close(Connection conn) {
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
