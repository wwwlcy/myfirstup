<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/pages/common/baselink.jsp" %>

	<script type="text/javascript">
		$(function(){
			$("input.pncart").click(function(){
				//alert("${requestScope.path}cartServlet?action=addCart&id=" + $(this).attr("addItemId"));
				//location.href = "${requestScope.path}cartServlet?action=addCart&id=" + $(this).attr("addItemId");
				$.getJSON("${requestScope.path}cartServlet", "action=addAjaxCart&id=" + $(this).attr("addItemId"), function(json){
					 // alert("JSON Data: " +json.lastName);
					  //这两个按钮显示的都需要绑定事件，不然不刷新就不会显示
					  $("#cartTotalCount").html("您的购物车中有"+json.cartTotalCount+"件商品");
					  $("#lastNmae").html("您刚刚将<span style=\"color: red\" >"+json.lastName+"</span>加入到了购物车中")
					});
			});
			
		});
	
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<c:if test="${empty sessionScope.user }">
					<a href="pages/user/login.jsp">登录</a> | 
					<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				</c:if>
				<c:if test="${not empty sessionScope.user }">
					<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
					<a href="userServlet?action=exist">注销</a>&nbsp;&nbsp;
				</c:if>
					<a href="pages/cart/cart.jsp">购物车</a>
					<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="/book/client/IndexServlet" method="post">
						<input  type="hidden" name="action" value="pageForPrice"/>
					价格：<input id="min" type="text" name="min" value="${param.min }"> 元 - 
						<input id="max" type="text" name="max" value="${param.max }"> 元 
						<input type="submit" value="查询" />
				</form>
			</div>
			<c:choose>
				<c:when test="${ empty sessionScope.cart}">
					<div style="text-align: center">
					<span  id="cartTotalCount"></span>
					<div id="lastNmae">
						<span style="color: red">你的购物车为空</span>
					</div>
				</div>
				</c:when>
				<c:otherwise>
					<div style="text-align: center">
					<span id="cartTotalCount">您的购物车中有${cart.totalCount}件商品</span>
					<div id="lastNmae">
						您刚刚将<span style="color: red" >${sessionScope.lastname }</span>加入到了购物车中
					</div>
				</div>
				</c:otherwise>
			</c:choose>
			<%-- <c:if test="${ empty sessionScope.cart}">
				<div style="text-align: center">
					<span></span>
					<div>
						<span style="color: red">你的购物车为空</span>
					</div>
				</div>
			</c:if> --%>
		<%-- 	 <c:if test="${not empty sessionScope.cart}">
				<div style="text-align: center">
					<span id="cartTotalCount">您的购物车中有${cart.totalCount}件商品</span>
					<div id="lastNmae">
						您刚刚将<span style="color: red" >${sessionScope.lastname }</span>加入到了购物车中
					</div>
				</div>
			</c:if>  --%>
			
			<c:forEach items="${requestScope.page.items }" var = "book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${book.imgPath}" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock}</span>
						</div>
						<div class="book_add">
							<input type="button" addItemId="${book.id }" 
								class="pncart" value="加入购物车" />
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
		<%@ include file="/pages/common/page.jsp" %>
	</div>
	<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>