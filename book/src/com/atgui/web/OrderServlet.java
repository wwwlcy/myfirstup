package com.atgui.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atgui.pojo.Cart;
import com.atgui.pojo.User;
import com.atgui.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends DaoServlet {
	private static final long serialVersionUID = 1L;
//http://localhost:8080/book/pages/user/login.jsp
	//http://localhost:8080/pages/user/login.jsp
	public void createOrder(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		if(null==user) {
			response.sendRedirect("/book/pages/user/login.jsp");
		}else {
			Cart cart=(Cart) request.getSession().getAttribute("cart");
			System.out.println(user.getId());
			String orderId = new OrderServiceImpl().createOrder(cart, user.getId());
			request.getSession().setAttribute("orderId", orderId);
			System.out.println(orderId);
			response.sendRedirect("/book/pages/cart/checkout.jsp");
		}
	}

}
