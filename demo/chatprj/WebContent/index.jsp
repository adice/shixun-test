<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<input type="text" name="username" />
		<%
			Object obj=request.getAttribute("msg");
			if(obj!=null){
				out.print("<font color='red'>"+obj+"</font>");
			}
		%>
		<br>
		<input type="submit" value="进入聊天室" />
	</form>
</body>
</html>