package com.atgui.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atgui.pojo.Book;
import com.atgui.pojo.Page;
import com.atgui.service.impl.PageService;
import com.atgui.utils.Exchange;

/**
 * Servlet implementation class ClientIndexServlet
 */
public class ClientIndexServlet extends DaoServlet {
	private static final long serialVersionUID = 1L;
       
	public  void pageIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("收到请求");
		String num = request.getParameter("pageNo");
		String size = request.getParameter("pageSize");
		Integer pageNo = Exchange.stringToInteger(num, 1);
		Integer pageSize = Exchange.stringToInteger(size, 4);
		Page<Book> page = new PageService().page(pageNo,pageSize);
		page.setPageUrl("client/IndexServlet?action=pageIndex");
		request.setAttribute("page", page);
		//response.sendRedirect(request.getContextPath()+"/bookServlet?action=list");
		request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
		
	}
	public  void pageForPrice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("收到请求");
		String num = request.getParameter("pageNo");
		String size = request.getParameter("pageSize");
		Integer pageNo = Exchange.stringToInteger(num, 1);
		Integer pageSize = Exchange.stringToInteger(size, 4);
		//http://localhost:8080/book/&pageNo=5
		String minprice = request.getParameter("min");
		String maxprice = request.getParameter("max");
		Integer mInteger=Exchange.stringToInteger(minprice, 0);
		Integer maxInteger = Exchange.stringToInteger(maxprice, Integer.MAX_VALUE);
		Page<Book> page=new PageService().pageByPrice(pageNo,pageSize,mInteger,maxInteger);
		if(mInteger==0 && maxInteger==Integer.MAX_VALUE) {
			//page = new PageService().page(pageNo,pageSize);
			page.setPageUrl("client/IndexServlet?action=pageForPrice");
		}else {
			//page = new PageService().pageByPrice(pageNo,pageSize,mInteger,maxInteger);
			page.setPageUrl("client/IndexServlet?action=pageForPrice&min="+mInteger+"&max="+maxInteger);
		}
		request.setAttribute("page", page);
		//response.sendRedirect(request.getContextPath()+"/bookServlet?action=list");
		request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
		
	}
}
