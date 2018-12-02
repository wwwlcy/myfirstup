package com.atgui.daoimpl;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.atgui.dao.BaseDao;
import com.atgui.utils.Jdbcutils;
public abstract class BaseDaoImpl<T> implements BaseDao {

		QueryRunner qr=new QueryRunner();
		private Class<T> type;
		public BaseDaoImpl() {
			//获得父类的泛型类型
			ParameterizedType type2 = (ParameterizedType) getClass().getGenericSuperclass();
			//System.out.println(type2);
			 type = (Class<T>) type2.getActualTypeArguments()[0];
			 //获得具体的泛型类型
			 //System.out.println(type);
			
		}
	@Override
	public int update(String sql, Object ...param) {
		Connection conn = Jdbcutils.getConnection();
		try {
			return qr.update(conn, sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public T QueryForOne(String sql, Object ...params) {
		Connection conn = Jdbcutils.getConnection();
		try {
			return qr.query(conn, sql, new BeanHandler<>(type),params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<T> QueryForList(String sql, Object ...params) {
		Connection connection = Jdbcutils.getConnection();
		try {
			return qr.query(connection, sql,new BeanListHandler<>(type),params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
