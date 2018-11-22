<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="refresh" content="1" />
</head>
<body>
<%
	Object obj=application.getAttribute("msgs");
	if(obj!=null){
		List<String> list=(List)obj;
		for(String temp:list){
			out.print(temp+"<br>");
		}
	}
%>
</body>
</html>