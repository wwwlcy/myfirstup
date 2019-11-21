<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div id="page_nav">
	
			<c:if test="${requestScope.page.pageNo >1}">
			
				<a href="${requestScope.page.pageUrl }&pageNo=1">首页</a>
				<a href="${requestScope.page.pageUrl }&pageNo=${requestScope.page.pageNo -1}">上一页</a>	
			</c:if>
			<c:choose>
				<c:when test="${requestScope.page.pageTotal<=5}" >
					<c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
						<c:if test="${requestScope.page.pageNo == i}">
							【${i}】
						</c:if>
						<c:if test="${requestScope.page.pageNo != i}">
							<a href="${requestScope.page.pageUrl }&pageNo=${i}">${i}</a>
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
									<a href="${requestScope.page.pageUrl }&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:when>
						<c:when test="${requestScope.page.pageNo >= requestScope.page.pageTotal-2}">
							<c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
								<c:if test="${requestScope.page.pageNo == i}">
									【${i}】
								</c:if>
								<c:if test="${requestScope.page.pageNo != i}">
									<a href="${requestScope.pageUrl }&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:when>
						<c:otherwise>
								<c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
								<c:if test="${requestScope.page.pageNo == i}">
									【${i}】
								</c:if>
								<c:if test="${requestScope.page.pageNo != i}">
									<a href="${requestScope.page.pageUrl }&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>
				
			<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
				<a href="${requestScope.page.pageUrl }&pageNo=${requestScope.page.pageNo +1}">下一页</a>
				<a href="${requestScope.page.pageUrl }&pageNo=${requestScope.page.pageTotal }">末页</a>
			</c:if>
			
				共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第
				<input value="${requestScope.page.pageNo }" name="pn" id="pn_input"/>页
				<input type="hidden" name="action" value = "page">
				<input type="button" id="sumbitButton" value="提交">
				
				<script type="text/javascript">
					$(function(){
						$("#sumbitButton").click(function(){
							//alert(123);
							var value=$("#pn_input").val();
							location.href="${requestScope.path}${requestScope.page.pageUrl }&pageNo="+value;
							//alert(456)
						});
					});
				</script>
		</div>