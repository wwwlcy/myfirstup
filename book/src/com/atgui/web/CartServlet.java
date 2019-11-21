package com.atgui.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atgui.pojo.Book;
import com.atgui.pojo.Cart;
import com.atgui.pojo.CartItem;
import com.atgui.service.impl.BookService;
import com.atgui.service.impl.BookServiceImpl;
import com.atgui.utils.BeanUtils;
import com.atgui.utils.Exchange;
import com.google.gson.Gson;

public class CartServlet extends DaoServlet {
	private static final long serialVersionUID = 1L;
	
	public void addAjaxCart(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//System.out.println("收到请求");
		String string = request.getParameter("id");
		Integer id = Exchange.stringToInteger(string, 0);
		BookService bookService = new BookServiceImpl();
		Book book = bookService.queryBookById(id);
		CartItem cartItem=new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(null==cart) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		cart.addItem(cartItem);
		String lastname=cartItem.getName();
		request.getSession().setAttribute("lastname", lastname);
		Map<String, Object> map = new HashMap<>();
		map.put("cartTotalCount", cart.getTotalCount());
		map.put("lastName", lastname);
		response.getWriter().write(new Gson().toJson(map));
		
		System.out.println(cart);
		//response.sendRedirect(request.getHeader("referer"));
	}
       
	//http://localhost:8080/book/cartServlet
	public void addCart(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//System.out.println("收到请求");
		String string = request.getParameter("id");
		Integer id = Exchange.stringToInteger(string, 0);
		BookService bookService = new BookServiceImpl();
		Book book = bookService.queryBookById(id);
		CartItem cartItem=new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(null==cart) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		cart.addItem(cartItem);
		String lastname=cartItem.getName();
		request.getSession().setAttribute("lastname", lastname);
		System.out.println(cart);
		response.sendRedirect(request.getHeader("referer"));
	}
	
	public void updateAjaxCart(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//System.out.println("收到请求");
		Integer id = Exchange.stringToInteger(request.getParameter("id"), 0);
		Integer count = Exchange.stringToInteger(request.getParameter("count"), 1);
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		BigDecimal newPrice = null;
		if(null !=cart) {
			newPrice = cart.updateItem(id, count);
		}
		Map<String,Object> map=new HashMap<>();
		map.put("count", count);
		map.put("totalCount", cart.getTotalCount());
		map.put("totalPrice", cart.getTotalPrice());
		map.put("newPrice", newPrice);
		
		//局部更新，不用转发  用Ajax请求
		response.getWriter().write(new Gson().toJson(map));
		//response.sendRedirect(request.getHeader("referer"));
	}
	
	public void updateCart(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//System.out.println("收到请求");
		Integer id = Exchange.stringToInteger(request.getParameter("id"), 0);
		Integer count = Exchange.stringToInteger(request.getParameter("count"), 1);
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		if(null !=cart) {
			cart.updateItem(id, count);
		}
		response.sendRedirect(request.getHeader("referer"));
	}
	
	public void deleteCart(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//System.out.println("收到请求");
		Integer idInteger = Exchange.stringToInteger(request.getParameter("id"), 0);
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(null !=cart) {
			cart.deleteItem(idInteger);
		}
		response.sendRedirect(request.getHeader("referer"));
	}

	
	public void clearCart(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//System.out.println("s收到请求");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(null!=cart) {
			cart.clearCart();
		}
		response.sendRedirect(request.getHeader("referer"));
	}

}
