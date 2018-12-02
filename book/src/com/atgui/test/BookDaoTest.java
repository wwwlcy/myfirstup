package com.atgui.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atgui.dao.BookDao;
import com.atgui.daoimpl.BookDaoImpl;
import com.atgui.pojo.Book;

public class BookDaoTest {
	private BookDaoImpl book =new BookDaoImpl();
	@Test
	public void testSaveBook() {
		int i = book.saveBook(new Book(null, "hhh", 99.99, "小张", 20, 50, null));
		System.out.println(i);
	}

	@Test
	public void testDeleteBookById() {
		System.out.println(book.deleteBookById(23));
	}

	@Test
	public void testUpdateBook() {
		Book book1=new Book(24, "aaa", 99, "小张", 20, 1, null);
		//book.updateBook(new Book(21, "独孤九剑", "冲冲", 99.9, 100000, 1, null));
		int i =book.updateBook(book1);
		System.out.println(i);
	}

	@Test
	public void testQueryBooks() {
		System.out.println(book.queryBooks().size());
	}

	@Test
	public void testQueryBookById() {
		System.out.println(book.queryBookById(23));
	}

}
