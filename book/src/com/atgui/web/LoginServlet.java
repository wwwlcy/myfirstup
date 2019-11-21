package com.atgui.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atgui.pojo.User;
import com.atgui.service.impl.Service;
import com.atgui.service.impl.ServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private Service ser = new ServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//验证是否收到请求
		//System.out.println("登陆成功");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(null !=ser.Login(new User(username, password, null))) {
			System.out.println("登录成功");
			request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "用户名或密码错误");
			request.setAttribute("username", username);
			System.out.println("用户名或密码错误");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
		
	}

}
