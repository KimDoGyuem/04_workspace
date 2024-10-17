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

<!-- 내가 추가한 부분 -->
<form action="/guest/read">
	<input name="bno" placeholder="읽을 번호입력">
	<input type="submit" value="읽기">
</form>

<form action="/guest/del">
	<input name="bno" placeholder="삭제할 번호입력">
	<input type="submit" value="삭제">
</form>

<form action="/guest/modify">
	<input name="bno" placeholder="수정할 번호입력">
	<input type="submit" value="수정">
</form>
<!-- 여기까지 -->

<a href="/test/updateVisitantCount">문제 1번 확인하러가기</a><hr>
<a href="/test/getOnePlusTwo">1+2 확인하러가기</a><hr>
<a href="/test/insertDoodle">문제 2번 확인하러가기</a><hr>
<a href="/test/delTest">문제 3번 확인하러가기</a><hr>
<a href="/guest/getList">방명록-list</a><hr>
<a href="/guest/read?bno=1">방명록-read</a><hr>
<a href="/guest/del?bno=2">방명록-del</a><hr>
<a href="/guest/write">방명록-write</a><hr>
<a href="/guest/modify?bno=1">방명록-modify</a><hr>
</body>
</html>
