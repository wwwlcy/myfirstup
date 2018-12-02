package com.atgui.web;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.atgui.pojo.User;
import com.atgui.service.impl.Service;
import com.atgui.service.impl.ServiceImpl;
import com.atgui.utils.BeanUtils;
import com.google.gson.Gson;

import javafx.scene.control.Alert;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends DaoServlet {
	private static final long serialVersionUID = 1L;
   // private 	User user=new User();
	private Service ser = new ServiceImpl();
	//封装进同一个抽象类，方便使用
	/*protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("login".equals(action)) {
			Login(request, response);
		}else {
			Regist(request, response);
		}
		System.out.println(action);
		try {
			//Method method = getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
			Method method = getClass().getMethod(action,HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}*/
	public void userNameExist(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, Exception {
		System.out.println("收到请求");
		String username = request.getParameter("username");
		Boolean usernameExist = ser.exist(username);
		Map<String, Boolean> map = new HashMap<>();
		map.put("username", usernameExist);
		new Gson().toJson(usernameExist);
		response.getWriter().write(new Gson().toJson(map));
		//页面没改
	}
	
	public void exist(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, Exception {
		//让session 会话失效
		request.getSession().invalidate();
		//转发回主页
		response.sendRedirect(request.getContextPath());
	}
	public void login(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, Exception {
		//验证是否收到请求
				//System.out.println("登陆成功");
				//String username = request.getParameter("username");
				//String password = request.getParameter("password");
				//BeanUtils.populate(user, request.getParameterMap());
				User user=new User();
				BeanUtils.getBean(user, request.getParameterMap());
				User loginUser = ser.Login(user);
				if(loginUser != null){
					System.out.println("登录成功");
					request.getSession().setAttribute("user", loginUser);
					request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "用户名或密码错误");
					request.setAttribute("username", user.getUsername());
					System.out.println("用户名或密码错误");
					request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
				}
				
			}
	
	public void regist(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	/*	String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");*/
		User user=new User();
		String token = (String) request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
		request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
		String code = request.getParameter("code");
		//System.out.println(username  + password + email + code );
		BeanUtils.getBean(user, request.getParameterMap());
		if(null!=token&&token.equalsIgnoreCase(code)) {
			//System.out.println(ser.exist(username));
			if(ser.exist(user.getUsername())) {
				System.out.println("注册成功");
				ser.regist(user);
				request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
			}else {
				System.out.println("用户名已存在");
				System.out.println("注册失败");
				request.setAttribute("msg", "用户名已存在");
				request.setAttribute("username", user.getUsername());
				request.setAttribute("email", user.getEamil());
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			}
			
		}else {
			request.setAttribute("username",  user.getUsername());
			request.setAttribute("email", user.getEamil());
			System.out.println("验证码错误");
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}
	

}

