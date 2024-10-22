<%@page import="com.test.dto.TGuestDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cp }/resources/common.css" >
</head>
<body>
<h1>방명록</h1>
<h2>글목록</h2>
<table>
	<tr>
		<td>번호</td>
		<td>내용</td>
	</tr>
<%
	Object o = request.getAttribute("list");
	List<TGuestDto> list = (List<TGuestDto>)o;
	for(int i=0; i<list.size(); i++){
		Long bno = list.get(i).getBno();
		String btext = list.get(i).getBtext();
%>
	<tr>
		<td><%=bno %></td>	
		<td><a href="${cp }/guest/read?bno=<%=bno%>"><%=btext %></a></td>
	</tr>
<%		
	}
%>	
</table>


<c:if test="${hasPrev }">
	<a href="${cp}/guest/getList?word=${word }&currentPage=${prevPage }">이전</a>
</c:if>

<c:forEach var="i" begin="${blockStartPage }" end="${blockEndPage }">
	<a href="${cp}/guest/getList?word=${word }&currentPage=${i}">${i}</a>
</c:forEach>

<c:if test="${hasNext }">
	<a href="${cp}/guest/getList?word=${word }&currentPage=${nextPage }">다음</a>
</c:if>

<br>

<form action="${cp }/guest/getList" method="get">
	<input name="word" placeholder="검색어 입력">
	<input type="submit" value="검색">
</form>

<a href="${cp }/guest/write">글쓰기</a>
</body>
</html>