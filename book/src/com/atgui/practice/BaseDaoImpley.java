package com.atgui.practice;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.atgui.utils.Jdbcutils;

public class BaseDaoImpley<T> implements BaseDao1<T> {
	
	private QueryRunner qr =new QueryRunner();
	private Class type;
	public BaseDaoImpley() {
		Type type2 = getClass().getGenericSuperclass();
		ParameterizedType pr = (ParameterizedType) type2;
		type=(Class) pr.getActualTypeArguments()[0];
		System.out.println(type);
	}

	@Override
	public int update(String sql, Object... params) {
		Connection connection = Jdbcutils.getConnection();
		try {
			return qr.update(connection, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jdbcutils.close(connection);
		}
		return -1;
	}

	@Override
	public T getone(String sql, Object... params) {
		Connection connection = Jdbcutils.getConnection();
		try {
			return qr.query(connection, sql, new BeanHandler<T>(type));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jdbcutils.close(connection);
		}
		return null;
	}

	@Override
	public List<T> getmany(String sql, Object... params) {
		Connection connection = Jdbcutils.getConnection();
		try {
			return qr.query(connection, sql, new BeanListHandler<>(type));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Jdbcutils.close(connection);
		}
		return null;
	}

}
