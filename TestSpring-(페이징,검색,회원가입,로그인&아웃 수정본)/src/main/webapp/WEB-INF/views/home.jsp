<%@page import="com.test.dto.RegDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="${cp }/resources/common.css">
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="/test/getOnePlusTwo">문제0번1</a><br>
<a href="/ttest/TgetOnePlusTwo">문제0번2</a><br>
<a href="/test/updateTest">문제1번</a><br>
<a href="/test/insertTest">문제2번</a><br>
<a href="/test/delTest">문제3번</a><br>
-----방명록 2차연습(contextPath적용)-----<br>
<a href="${cp }/guest/getList">방명록</a>
<a href="${cp }/guest/reg">회원가입</a>
<a href="${cp }/guest/log">로그인</a>
<a href="${cp }/guest/logOut">로그아웃</a>
<a href="${cp }/guest/test">쿠키</a>
<br>
<hr>
<%
Object o = 	session.getAttribute("log");
RegDto log = (RegDto)o;
String logtext = "";
if(o==null){
	logtext = "";
}else{
	logtext = "반갑습니다"+log.getId()+"님"; 
}
%>
<%=logtext %>
</form>
</body>
</html>
