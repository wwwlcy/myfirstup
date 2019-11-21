package com.atgui.service.impl;

import java.util.List;

import com.atgui.daoimpl.PageDao;
import com.atgui.pojo.Book;
import com.atgui.pojo.Page;
public class PageService {
	private PageDao pageDao=new PageDao();
	public Page<Book> page(Integer pageNo,Integer pageSize){
		Page<Book> page=new Page<>();
		Integer pageCount=pageDao.queryForTotalCount();
		List<Book> items = null;
		Integer pageTotal=0;
		if(pageSize>0) {
			//items=pageDao.queryForPageItems((pageNo-1)*pageSize, pageSize);
			if(pageCount%pageSize!=0) {
				pageTotal=pageCount/pageSize+1;
			}else {
				pageTotal=pageCount/pageSize;
			}
		}else {
			//pageDao.queryForPageItems((pageNo-1)*page.getPageSize(), page.getPageSize());
			if(pageCount%page.getPageSize() != 0) {
				pageTotal=pageCount/page.getPageSize()+1;
			}else {
				pageTotal=pageCount/page.getPageSize();
			}
		}
		page.setPageTotal(pageTotal);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		//page.setPageTotal(pageTotal);
		page.setPageTotalCount(pageCount);
		items=pageDao.queryForPageItems((page.getPageNo()-1)*pageSize, pageSize);
		page.setItems(items);
		return page;	
	}
	public Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer minprice, Integer maxprice) {
		
		Page<Book> page=new Page<>();
		Integer pageCount=pageDao.queryForTotalCountByPrice(minprice,maxprice);
		List<Book> items = null;
		Integer pageTotal=0;
		if(pageSize>0) {
			//items=pageDao.queryForPageItems((pageNo-1)*pageSize, pageSize);
			if(pageCount%pageSize!=0) {
				pageTotal=pageCount/pageSize+1;
			}else {
				pageTotal=pageCount/pageSize;
			}
		}else {
			//pageDao.queryForPageItems((pageNo-1)*page.getPageSize(), page.getPageSize());
			if(pageCount%page.getPageSize() != 0) {
				pageTotal=pageCount/page.getPageSize()+1;
			}else {
				pageTotal=pageCount/page.getPageSize();
			}
		}
		page.setPageTotal(pageTotal);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		//page.setPageTotal(pageTotal);
		page.setPageTotalCount(pageCount);
		items=pageDao.queryForPageItemsByprice((page.getPageNo()-1)*pageSize, pageSize,minprice,maxprice);
		page.setItems(items);
		return page;
	}
}
