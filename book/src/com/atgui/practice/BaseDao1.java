package com.atgui.practice;

import java.util.List;

//这个接口主要是定义对数据库操作的一些规范
public interface BaseDao1 <T>{
	/*
	 * 数据库更新（增删改）
	 */
	public int update(String sql,Object ... params);
	
	//查询一个记录
	public T getone(String sql, Object ... params);
	
	//查询多个记录
	public List<T> getmany(String sql, Object ... params);

}
