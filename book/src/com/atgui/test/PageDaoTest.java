package com.atgui.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atgui.daoimpl.PageDao;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class PageDaoTest {

	PageDao page=new PageDao();
 	@Test
	public void testQueryForTotalCount() {
		System.out.println(page.queryForTotalCount());
	}

	@Test
	public void testQueryForPageItems() {
		System.out.println(page.queryForPageItems(0, 4));
	}
	@Test
	public void queryForPageItemsByprice() {
		System.out.println(page.queryForPageItemsByprice(16,4,0,100000000));
	}
	@Test
	public void queryForTotalCountByPrice() {
		System.out.println(page.queryForTotalCountByPrice(10, 50));
	}

}
