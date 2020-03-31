<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<title>Products</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="${ctx }/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="${ctx }/css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="${ctx }/css/form.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="${ctx }/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx }/js/bootstrap-3.1.1.min.js"></script>
<!-- //js -->	
<!-- cart -->
<script src="${ctx }/js/simpleCart.min.js"> </script>
<!-- cart -->
<!-- the jScrollPane script -->
<script type="text/javascript" src="${ctx }/js/jquery.jscrollpane.min.js"></script>
		<script type="text/javascript" id="sourcecode">
			$(function()
			{
				$('.scroll-pane').jScrollPane();
			});
		</script>
<!-- //the jScrollPane script -->
<script type="text/javascript" src="${ctx }/js/jquery.mousewheel.js"></script>
<!-- the mousewheel plugin -->	
<script type="text/javascript">
	function buy(id){
		var q = $("#quantity"+id).val();
		$.get("${ctx }/cart",{"id":id,"q":q},function(data){
			var re = eval(data);
			if(re.result=="nologin"){
				alert("请登录之后再购买！");
			}else{
				alert("购买成功！");
				$("#info").text(re.result);
			}
		},"json");
	}
</script>	
</head>
<body>
	<!--header-->
	<%@ include file="layout/header.jsp" %>
	<!--//header-->
	<!--products-->
	<div class="products">	 
		<div class="container">
			<h2>Our Products</h2>			
			<div class="col-md-9 product-model-sec">
				<c:forEach items="${page.list }" var="cake">
				<div class="product-grid">
					<a href="${ctx }/cake/get?id=${cake.id}">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="${ctx }/images/m9.png" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button> View </button>
							</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<c:set var="redParam" value="<font color='red'>${param.name }</font>"></c:set>
							<h4>${fn:replace(cake.name, param.name, redParam) }</h4>								
							<span class="item_price">￥${cake.price }</span>
							<div class="ofr">
								<p class="pric1"><del>$2300.00</del></p>
								<p class="disc">[15% Off]</p>
							</div>
							<input type="text" id="quantity${cake.id }" class="item_quantity" value="1" />
							<input type="button" onclick="buy(${cake.id })" class="item_add items" value="Add">
							<div class="clearfix"> </div>
						</div>						
					</div>
				</div>
				</c:forEach>
				<div align="center">
					共有${page.totalCount } 条，共${page.totalPageNum } 页，
					<a href="${ctx }/cake/list?pageNum=1&type=${param.type }&name=${param.name }">首页</a>
					<a href="${ctx }/cake/list?pageNum=${page.prePageNum }&type=${param.type }&name=${param.name }">上一页</a>
					<a href="${ctx }/cake/list?pageNum=${page.nextPageNum }&type=${param.type }&name=${param.name }">下一页</a>
					<a href="${ctx }/cake/list?pageNum=${page.totalPageNum }&type=${param.type }&name=${param.name }">末页</a>
				</div>
			</div>	
			<div class="col-md-3 rsidebar span_1_of_left">
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>DISCOUNTS</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
							<form action="${ctx }/cake/list" method="post">
								<input type="text" name="name" value="${param.name }" />
								<input type="hidden" name="type" value="${param.type }" />
								<input type="submit" value="search" />
							</form>
						</div>
					</div>
				</section>  				 
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--//products-->
	<!--footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-grids">
				<div class="col-md-2 footer-grid">
					<h4>company</h4>
					<ul>
						<li><a href="products.html">products</a></li>
						<li><a href="#">Work Here</a></li>
						<li><a href="#">Team</a></li>
						<li><a href="#">Happenings</a></li>
						<li><a href="#">Dealer Locator</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid">
					<h4>service</h4>
					<ul>
						<li><a href="#">Support</a></li>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Warranty</a></li>
						<li><a href="contact.html">Contact Us</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid">
					<h4>order & returns</h4>
					<ul>
						<li><a href="#">Order Status</a></li>
						<li><a href="#">Shipping Policy</a></li>
						<li><a href="#">Return Policy</a></li>
						<li><a href="#">Digital Gift Card</a></li>
					</ul>
				</div>
				<div class="col-md-2 footer-grid">
					<h4>legal</h4>
					<ul>
						<li><a href="#">Privacy</a></li>
						<li><a href="#">Terms and Conditions</a></li>
						<li><a href="#">Social Responsibility</a></li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid icons">
					<h4>Connect with Us</h4>
					<ul>
						<li><a href="#"><img src="${ctx }/images/i1.png" alt=""/>Follow us on Facebook</a></li>
						<li><a href="#"><img src="${ctx }/images/i2.png" alt=""/>Follow us on Twitter</a></li>
						<li><a href="#"><img src="${ctx }/images/i3.png" alt=""/>Follow us on Google-plus</a></li>
						<li><a href="#"><img src="${ctx }/images/i4.png" alt=""/>Follow us on Pinterest</a></li>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--//footer-->
	<div class="footer-bottom">
		<div class="container">
			<p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.17sucai.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
		</div>
	</div>
</body>
</html>