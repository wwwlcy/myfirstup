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
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 注册 
	 */
	private Service ser = new ServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//System.out.println("获得请求");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		//System.out.println(username  + password + email + code );
		if("abcde".equalsIgnoreCase(code)) {
			//System.out.println(ser.exist(username));
			if(ser.exist(username)) {
				System.out.println("注册成功");
				ser.regist(new User(username, password, email));
				request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
			}else {
				System.out.println("用户名已存在");
				System.out.println("注册失败");
				request.setAttribute("msg", "用户名已存在");
				request.setAttribute("username", username);
				request.setAttribute("email", email);
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			}
			
		}else {
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			System.out.println("验证码错误");
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

}
