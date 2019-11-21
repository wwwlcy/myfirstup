<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>赶集网会员注册页面</title>
	<%@ include file="/pages/common/baselink.jsp" %>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}	
	</style>
	<script type="text/javascript">
		//alert($());
		$(function(){
			//为用户名绑定失去焦点事件
			$("#username").blur(function(){
				var name=this.value;
				//alert(name);
				//alert("${path}userServlet")
				$.getJSON("${path}userServlet", "action=userNameExist&username="+name, function(json){
					  if(json.username==false){
						  $("span.errorMsg").text("用户名已存在");
					  }
					  if(json.username==true){
						  $("span.errorMsg").text("");
					  }
					});
			});
			
			$("#image").click(function(){
				//alert(1)
				this.src="Kaptcha.jpg?d="+new Date();
			});
			$("#sub_btn").click(function(){
				//alert(23);
				var username = $("#username").val();
				var patt1 = /^[\w]{5,12}$/;
				if(!patt1.test(username)){
					//alert(123);
					$("span.errorMsg").text("用户名输入不合法");
					return false;
				}
				var password = $("#password").val();
				var patt = /^[\w]{5,12}$/;
				if(!patt.test(password)){
					$("span.errorMsg").text("密码输入不合法");
					return false;
				}
				var repwd = $("#repwd").val();
				if(repwd != password){
					$("span.errorMsg").text("两次密码输入不一致");
					return false;
				}  
			 	var email = $("#email").val();
				//alert(email);
				var pattemail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				//alert(123);
				if(pattemail.test(email) == false){
					//alert(123);
					$("span.errorMsg").text("邮箱格式不对");
					return false;
				} 
				
				var code = $("#code").val();
				code =$.trim(code);
				if(code ==""){
					$("span.errorMsg").text("请输入验证码");
					return false;
				} 
				
				$("span.errorMsg").text("");
				return true;
			});
		});
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册赶集网会员</h1>
								<span class="errorMsg">
									<%-- <%= request.getAttribute("msg")==null?"":request.getAttribute("msg") %> --%>
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
								<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" 
									value ="${requestScope.username}" 
									autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" 
									value ="" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" 
									value ="" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" 
									value ="${requestScope.email}" 
									autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" value = "" type="text" style="width: 120px;" name="code" id="code"/>
									<img id="image" alt="" src="Kaptcha.jpg" style="float: right; margin-right: 40px" height="30px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>