<%@page import="com.peisia.dto.GuestDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//Model 에 "list" 라는 키로 넣은 객체를 request 내장객체에서 빼올 수 있음.
	
	Object o = request.getAttribute("list");
	ArrayList<GuestDto> list = (ArrayList<GuestDto>)o; 
	for(int i=0;i<list.size();i++){
		Long bno = list.get(i).getBno();
		String btext = list.get(i).getBtext();
%>		
		<%=bno %>	
		<%=btext %>	
		<hr>  
<%		
	}

%>

<!-- jstl 방식 (맨 위쪽에 라이브러리 태그 추가 확인할것)-->
<c:forEach var="guest" items="${list}">
    ${guest.bno}
    ${guest.btext}
    <hr>
</c:forEach>

</body>
</html>