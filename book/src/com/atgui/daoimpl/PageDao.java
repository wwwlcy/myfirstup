package com.atgui.daoimpl;

import java.util.List;

import com.atgui.pojo.Book;

public class PageDao extends BaseDaoImpl<Book> {

	public Integer queryForTotalCount() {
		String sql="SELECT * FROM t_book;";
		List<Book> list = QueryForList(sql);
		return list.size();
		
	}
	
	public List<Book> queryForPageItems(Integer begin, Integer size){
		String sql="SELECT * FROM t_book LIMIT ?,?;";
		return QueryForList(sql, begin,size);
		//return null;	
	}

	public List<Book> queryForPageItemsByprice(Integer i, Integer pageSize, Integer minprice, Integer maxprice) {
		String sql="SELECT * FROM t_book WHERE price BETWEEN ? AND ?  LIMIT ?,?;";
		return QueryForList(sql, minprice,maxprice,i,pageSize);
	}

	public Integer queryForTotalCountByPrice(Integer minprice, Integer maxprice) {
		String sql="SELECT * FROM t_book WHERE price BETWEEN ? AND ?";
		List<Book> forList = QueryForList(sql, minprice,maxprice);
		return forList.size();
	}
}
