package com.atgui.dao;

import java.sql.Connection;
import java.util.List;

public interface BaseDao<T> {
	
	public int update(String sql,Object...args);
	public T QueryForOne( String sql,Object...args);
	public List<T> QueryForList(String sql,Object...args);
}
