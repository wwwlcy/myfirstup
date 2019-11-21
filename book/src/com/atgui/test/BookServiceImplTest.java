package com.atgui.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atgui.pojo.Book;
import com.atgui.service.impl.BookServiceImpl;

public class BookServiceImplTest {
	BookServiceImpl service = new BookServiceImpl();
	@Test
	public void testAdd() {
		System.out.println(service.add(new Book(null, "123", 88, "aaa", 80, 5, null)));
		
	}

	@Test
	public void testDeleteBookById() {
		System.out.println(service.deleteBookById(25));
	}

	@Test
	public void testUpdateBook() {
		System.out.println(service.updateBook(new Book(25, "123", 9, "aaa", 80, 5, null)));
	}

	@Test
	public void testQueryBooks() {
		System.out.println(service.queryBooks().size());
	}

	@Test
	public void testQueryBookById() {
		System.out.println(service.queryBookById(25));
	}

}
