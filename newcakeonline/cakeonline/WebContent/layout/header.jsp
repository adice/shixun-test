<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	function login4ajax(){
		var email = $("#email").val();
		var pwd = $("#password").val();
		$.post("${ctx }/login4Ajax",{"email":email,"password":pwd},function(result){
			console.log(result);
			var re = eval(result);
			if(re.r=="ok"){
				$("#loginBox").html("欢迎您登录！"+re.name);
			}
			if(re.r=="fail"){
				$("#errorInfo").text("您的账号密码错误");
			}
		},"json");
	}
</script>
<div class="header">
		<div class="container">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<h1 class="navbar-brand"><a  href="index.html">Yummy</a></h1>
				</div>
				<!--navbar-header-->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="InitServlet" class="active">Home</a></li>
						<c:forEach items="${types }" var="type1">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">${type1.name }<b class="caret"></b></a>
							<ul class="dropdown-menu multi-column columns-4">
								<div class="row">
									<div class="col-sm-3">
										<ul class="multi-column-dropdown">
											<c:forEach items="${type1.types }" var="type2">
											<li><a class="list" href="${ctx }/cake/list?type=${type2.id }">${type2.name }</a></li>
											</c:forEach>
										</ul>
									</div>																		
								</div>
							</ul>
						</li>
						</c:forEach>
					</ul> 
					<!--/.navbar-collapse-->
				</div>
				<!--//navbar-header-->
			</nav>
			<div class="header-info">
				<div class="header-right search-box">
					<a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>				
					<div class="search">
						<form class="navbar-form">
							<input type="text" class="form-control">
							<button type="submit" class="btn btn-default" aria-label="Left Align">
								Search
							</button>
						</form>
					</div>	
				</div>
				<div class="header-right login">
					<a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
					<div id="loginBox">
						<c:if test="${empty user }">
						<form id="loginForm" action="${ctx }/login" method="post">
							<fieldset id="body">
								<fieldset>
									<label for="email">Email Address</label>
									<input type="text" name="email" id="email">
								</fieldset>
								<fieldset>
									<label for="password">Password</label>
									<input type="password" name="password" id="password">
									<span id="errorInfo">${info }</span>
								</fieldset>
								<input type="submit" id="login" value="Sign in">
								<a href="javascript:login4ajax()">Sign in 4 Ajax</a>
								<label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember me</i></label>
							</fieldset>
							<p>New User ? <a class="sign" href="javascript:login4ajax();">Sign Up</a> <span><a href="#">Forgot your password?</a></span></p>
						</form>
						</c:if>
						<c:if test="${not empty user }">
							<fieldset>
								欢迎您登录，${user.nickName }
							</fieldset>
							<fieldset>
								退出登录
							</fieldset>
						</c:if>
					</div>
				</div>
				<div class="header-right cart">
					<a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></a>
					<div class="cart-box">
						<h4><a href="checkout.html">
							<span id="info" class="simpleCart_total"></span>
						</a></h4>
						<p><a href="javascript:;" class="simpleCart_empty">Empty cart</a></p>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>