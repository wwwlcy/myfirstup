<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path=request.getScheme()+"://"+
    				request.getServerName()+
    				":"+request.getServerPort()
    				+request.getContextPath()+"/";
    	request.setAttribute("path", path);
    %>
<base href="<%=path %>"/>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>