<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
	<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>Notice List Page</h1>
	
	<div class="container-fluid">
		<div class="col-md-8 mx-auto my-auto">
		<table class="table table-dark table-hover">
			<tr>
				<th>Number</th><th>TITLE</th><th>WRITER</th><th>REGDATE</th><th>HITS</th>
			</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td><a href="./noticeSelect?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.writer}</td>
				<td>${dto.regDate}</td>
				<td>${dto.hits}</td>
			</tr>	
		</c:forEach>
		</div>
		</table>
		<a href="./noticeInsert" class="btn btn-danger">ADD</a>
</body>
</html>