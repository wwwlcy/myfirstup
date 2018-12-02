package com.atgui.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atgui.pojo.Book;
import com.atgui.pojo.Page;
import com.atgui.service.impl.BookServiceImpl;
import com.atgui.service.impl.PageService;
import com.atgui.utils.BeanUtils;
import com.atgui.utils.Exchange;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends DaoServlet {
	private BookServiceImpl bookservice = new BookServiceImpl();
	private static final long serialVersionUID = 1L;
	public void add(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("+++++");
		
		Book book=BeanUtils.getBean(new Book(), request.getParameterMap());
		int i = bookservice.add(book);
		//转发到成功页面
		//http://localhost:8080/book/manager/bookServlet?action=list
		response.sendRedirect(request.getContextPath()+"/manager//bookServlet?action=page&pageNo="+Integer.MAX_VALUE);
		
	}
	//已经被page 类给替代
	public void list(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Book> books = bookservice.queryBooks();
		request.setAttribute("list", books);
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
	public void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("收到请求");
		String id = request.getParameter("id");
		//int i = Integer.parseInt(id);
		int i=Exchange.stringToInteger(id, 0);
		 bookservice.deleteBookById(i);
		response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));
	}
	public void getBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("收到请求");
		String id = request.getParameter("id");
		//int i = Integer.parseInt(id);
		int i=Exchange.stringToInteger(id, 0);
		Book book = bookservice.queryBookById(i);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	public void updateBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("收到请求");
		Book book=BeanUtils.getBean(new Book(), request.getParameterMap());
		//String id = request.getParameter("id");
		//Integer integer = Exchange.stringToInteger(id, 0);
		//book.setId(integer);
		//System.out.println(book);
		String string = request.getParameter("pageNo");
		Integer pageNo = Exchange.stringToInteger(string, 1);
		bookservice.updateBook(book);
		response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
	}
	public void page(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("收到请求");
		//String pn = request.getParameter("pn");
		//Integer pnum = Exchange.stringToInteger(pn, 4);
		String num = request.getParameter("pageNo");
		String size = request.getParameter("pageSize");
		Integer pageNo = Exchange.stringToInteger(num, 1);
		Integer pageSize = Exchange.stringToInteger(size, 4);
		Page<Book> page = new PageService().page(pageNo,pageSize);
		page.setPageUrl("manager/bookServlet?action=page");
		request.setAttribute("page", page);
		//response.sendRedirect(request.getContextPath()+"/bookServlet?action=list");
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}

}
