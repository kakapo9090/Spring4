<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
	
<c:import url="./temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="./temp/boot_nav.jsp"></c:import>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	<c:if test="${not empty member}"> 
	<h3>Login이 성공 했을때 보이는 문장</h3>
	</c:if>
	
	<c:if test="${empty member}">
	<h3>Login을 하기전 보이는 문장</h3>
	</c:if>
</body>
</html>