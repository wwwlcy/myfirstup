<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@ include file="/pages/common/baselink.jsp" %>
	<script type="text/javascript">
		$(function(){
			$("a.delet").click(function(){
				//alert(123);
				var name=$(this).parent().parent().find("td:first").text();
				return confirm("你确定要删除["+name+"]吗？");
				//return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗?") 
				//return false;
			});	
			/* $(":button").click(function(){
				//alert(123);
				var value=$("#pn_input").val();
				location.href="${requestScope.path}/manager/bookServlet?action=page&pageNo="+value;
				//alert(456)
			}); */
		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@ include file="/pages/common/bookmanage.jsp" %>
	</div>
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>		
			<c:forEach items="${requestScope.page.items }" var="book">
				<tr>
					<td>${book.name }</td>
					<td>${book.price }</td>
					<td>${book.author }</td>
					<td>${book.sales }</td>
					<td>${book.stock }</td>
					<td><a href="/book/manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<td><a class="delet" href="/book/manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
				</c:forEach>
				<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				
				<td><a href="/book/pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>
		</table>
		<!-- //http://localhost:8080/book/bookServlet?action=page&pageNo=1 -->
		<%-- <div id="page_nav">
			<c:if test="${requestScope.page.pageNo >1}">
				<a href="manager/bookServlet?action=page&pageNo=1">首页</a>
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo -1}">上一页</a>	
			</c:if>
			<c:choose>
			<c:when test="${requestScope.page.pageTotal<=5}" >
				<c:forEach begin="1" end="5" var="i">
					<c:if test="${requestScope.page.pageNo == i}">
						【${i}】
					</c:if>
					<c:if test="${requestScope.page.pageNo != i}">
						<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
					</c:if>
				</c:forEach>
				</c:when>
				<c:when test="${requestScope.page.pageTotal>5}">
						<c:choose  >
						<c:when test="${requestScope.page.pageNo<=3}">
							<c:forEach begin="1" end="5" var="i">
								<c:if test="${requestScope.page.pageNo == i}">
									【${i}】
								</c:if>
								<c:if test="${requestScope.page.pageNo != i}">
									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:when>
						<c:when test="${requestScope.page.pageNo >= requestScope.page.pageTotal-2}">
							<c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
								<c:if test="${requestScope.page.pageNo == i}">
									【${i}】
								</c:if>
								<c:if test="${requestScope.page.pageNo != i}">
									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
								<c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
								<c:if test="${requestScope.page.pageNo == i}">
									【${i}】
								</c:if>
								<c:if test="${requestScope.page.pageNo != i}">
									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>
			
				<a href="bookServlet?action=page&pageNo=${requestScope.page.pageNo -1}">${requestScope.page.pageNo -1}</a>
				【${requestScope.page.pageNo}】
				<a href="bookServlet?action=page&pageNo=${requestScope.page.pageNo +1}">${requestScope.page.pageNo +1}</a>
				
			<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo +1}">下一页</a>
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal }">末页</a>
			</c:if>
				共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第
				<input value="${requestScope.page.pageNo }" name="pn" id="pn_input"/>页
				<input type="hidden" name="action" value = "page">
				<input type="button" value="提交">
				
				<script type="text/javascript">
					$(function(){
						$(":button").click(function(){
							//alert(123);
							var value=$("#pn_input").val();
							location.href="${requestScope.path}/manager/bookServlet?action=page&pageNo="+value;
							//alert(456)
						});
					});
				</script>
		</div> --%>
		<%@ include file="/pages/common/page.jsp" %>
	</div>
	
	<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>