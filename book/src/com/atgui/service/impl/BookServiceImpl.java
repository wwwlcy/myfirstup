package com.atgui.service.impl;

import java.util.List;

import com.atgui.dao.BookDao;
import com.atgui.daoimpl.BookDaoImpl;
import com.atgui.pojo.Book;

public class BookServiceImpl implements BookService {
	BookDao bookDao = new BookDaoImpl();
	@Override
	public int add(Book book) {
		
		return bookDao.saveBook(book);
	}

	@Override
	public int deleteBookById(Integer id) {
		
		return bookDao.deleteBookById(id);
	}

	@Override
	public int updateBook(Book book) {
		
		return bookDao.updateBook(book);
	}

	@Override
	public List<Book> queryBooks() {
		// TODO Auto-generated method stub
		return bookDao.queryBooks();
	}

	@Override
	public Book queryBookById(Integer id) {
		// TODO Auto-generated method stub
		return bookDao.queryBookById(id);
	}

}
