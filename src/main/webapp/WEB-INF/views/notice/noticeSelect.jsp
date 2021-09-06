<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
<h1>Notice Select Page1</h1>

	<div class="container-fluid">
		<h3>번호 : ${dto.num}</h3>
		<h3>제목 : ${dto.title}</h3>
		<h3>내용 : ${dto.contents}</h3>
		<h3>작성자 : ${dto.writer}</h3>
		<h3>작성일 : ${dto.regDate}</h3>
		<h3>조회수 : ${dto.hits}</h3>
		
		<a href="./noticeDelete?num=${dto.num}">Delete</a>
		<a href="./noticeUpdate?num=${dto.num}">Update</a>
	</div>
	

</body>
</html>