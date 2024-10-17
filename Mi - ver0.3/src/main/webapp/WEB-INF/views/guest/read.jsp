<%@page import="com.peisia.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	GuestDto read = (GuestDto)request.getAttribute("read");
	long bno = read.getBno();
	String btext = read.getBtext();
%>	

글본문<br>
글번호:<%=bno %><br>
글내용:<%=btext %><br>


<!-- el 방식 -->
<hr>
글 읽기<br>
글번호:${read.bno}<br>
글내용:${read.btext}<br>


</body>
</html>