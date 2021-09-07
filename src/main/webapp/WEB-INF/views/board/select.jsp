<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>${board}Select Page</h1>
	
	<div class="container-fluid">
		<h3>NUM:${dto.num}</h3>
		<h3>Title:${dto.title}</h3>
		<h3>Contents:${dto.contents}</h3>
		<h3>Writer:${dto.writer}</h3>
		<h3>DATE:${dto.regDate}</h3>
		<h3>HITS:${dto.hits}</h3>
	
	<a href="./delete?num=${dto.num}">DELETE</a>
	<a href="./update?num=${dto.num}">UPDATE</a>
	<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}">REPLY</a>
	</c:if>
	</div>
	
	

</body>
</html>