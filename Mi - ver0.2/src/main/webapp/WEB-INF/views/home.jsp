<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="/spring/test/getOnePlusTwo">1+2 확인하러가기</a>
<a href="/spring/test/updateVisitantCount">문제 1번 확인하러가기</a>
<a href="/spring/test/insertDoodle">문제 2번 확인하러가기</a>
<a href="/spring/test/delTest">문제 3번 확인하러가기</a>
</body>
</html>
