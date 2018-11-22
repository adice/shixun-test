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
		List<String> list=(List)application.getAttribute("names");
		String name=session.getAttribute("myname").toString();
		for(String temp:list){
			if(temp.equals(name)){
				out.print("<span><font color='red'>"+temp+"</font><br>");
			}else{
				out.print("<font color='blue'>"+temp+"</font><br>");
			}
		}
	%>
</body>
</html>