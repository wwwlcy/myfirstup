package com.atgui.service.impl;

import java.util.List;

import com.atgui.pojo.Book;

public interface BookService {
	public int add(Book book);
	public int deleteBookById(Integer id);
	public int updateBook(Book book);
	public List<Book> queryBooks();
	public Book queryBookById(Integer id);

}
