<%@page import="com.test.dto.RegDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cp }/resources/common.css">
</head>
<body>
	<form action="${cp }/guest/log" method="post">
		<input name="id" placeholder="아이디입력"><br>
		<input name="pw" placeholder="비번입력"><br>
		<input type="submit" value="로그인">
	</form>
<%
	Object o = 	session.getAttribute("log");
	RegDto log = (RegDto)o;
	String logtext = "";
	if(o==null){
		logtext="비로그인 상태입니다";
	}else{
		logtext = log.getId()+"으로 로그인 중입니다";
	}
%>
	<%=logtext %>
	<br>
	<a href="${cp }/">홈으로</a>
	
</body>
</html>