package com.atgui.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atgui.pojo.Book;
import com.atgui.pojo.Page;
import com.atgui.service.impl.PageService;

public class PageServiceTest {

	@Test
	public void test() {
		PageService page = new PageService();
		Page<Book> page2 = page.page(2, 5);
		System.out.println(page2);
	}

}
