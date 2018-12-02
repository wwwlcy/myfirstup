<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/pages/common/baselink.jsp" %>
	<script type="text/javascript">
		$(function(){
			$("a.delete").click(function(){
				//alert(213);
				//var name=$(this).parent().parent()children("td:first").html();
			    var name = $(this).parent().parent().children("td:first").html();
				return confirm("你确定用删除【"+name+"】吗？");
				//return false;
			});
			$("#clearCart").click(function(){
				return confirm("你确定要清空购物车吗？");
			});
			$("input.update").change(function(){
				//alert(132)
				var name=$(this).parent().parent().children("td:first").html();
				if(confirm("你确定修改【"+name+"】值为： "+this.value)){
					var value=this.value;
					var obj=$(this).parent().parent().find("td:eq(3)");
					//location.href="${requestScope.path}cartServlet?action=updateCart&id="+$(this).attr("updateId")+"&count="+this.value;
					$.getJSON("${requestScope.path}cartServlet", "action=updateAjaxCart&id="
							+$(this).attr("updateId")+"&count="+this.value, function(json){
						 $(".b_count").html(json.totalCount);
						 $(".b_price").html(json.totalPrice)
						 value=json.count;
						 obj.html(json.newPrice);
						// alert(html);
						});
					
					this.value=value;					
				}else{
					this.value=this.defaultValue;
				}
			});
			
		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
				<%@ include file="/pages/common/header.jsp" %>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items }">
				<tr>
					<td colspan="5"><a href="index.jsp">你的购物车空空如也，快去添加购物车</a></td>
					
				</tr>	
			</c:if>
			<c:if test="${ not empty sessionScope.cart.items }">
				<c:forEach items="${sessionScope.cart.items }" var="entry">
					<tr>
						<td>${entry.value.name }</td>
						<td>
							<input type="text" value="${entry.value.count }" style="width: 35px" class="update" updateId="${entry.value.id}">
						
						</td>
						<td>${entry.value.price }</td>
						<td>${entry.value.priceTotal }</td>
						<td><a href="/book/cartServlet?action=deleteCart&id=${entry.value.id }" class="delete">删除</a></td>
					</tr>
				</c:forEach>		
			</c:if>
			<!-- <tr>
				<td>母猪的产后护理</td>
				<td>1</td>
				<td>10.00</td>
				<td>10.00</td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>百年孤独</td>
				<td>1</td>
				<td>20.00</td>
				<td>20.00</td>
				<td><a href="#">删除</a></td>
			</tr>	 -->	
			
		</table>
	<c:if test="${ not empty sessionScope.cart.items }">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount }</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice }</span>元</span>
			<span class="cart_span"><a id="clearCart" href="/book/cartServlet?action=clearCart">清空购物车</a></span>
			<span class="cart_span"><a href="/book/orderServlet?action=createOrder">去结账</a></span>
		</div>
	</c:if>
	</div>
	
	<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>