package com.atgui.dao;

import java.util.List;

import com.atgui.pojo.Book;

public interface BookDao {
	public int saveBook(Book book);
	/*saveBook				添加图书
	deleteBookById		删除图书
	updateBook			更新图书
	queryBooks			查询全部图书
	queryBookById*/
	public int deleteBookById(int id);
	
	public int updateBook(Book book);
	
	public List<Book> queryBooks();
	
	public Book queryBookById(int id);
	
	//public Integer queryTotal();
}
