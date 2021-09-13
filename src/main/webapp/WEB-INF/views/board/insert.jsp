<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
<style type="text/css">
	.er{
		color: red;
	}
</style>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>${board}Insert Page</h1>


<div class="container-fluid">
	
		<form id="frm" class="col-md-6 mx-auto" action="./insert" method="post" >
		  <div class="mb-3">
		    <label for="title" class="form-label">TITLE</label>
		    <input type="text" class="form-control" name="title" id="title" placeholder="Enter Title">
		 	<div id="t_1" class="er"></div>
		  </div>
		  
		  <div class="mb-3">
		    <label for="writer" class="form-label">Writer</label>
		    <input type=text" class="form-control" name="writer" id="writer" value="${member.id}" readonly >
		 	<div id="w_1" class="er"></div>
		  </div>
		  
		  <div class="mb-3">
		   <label for="exampleFormControlTextarea1" class="form-label">Contents</label>
  			<textarea class="form-control" cols=""  name="contents" id="exampleFormControlTextarea1" rows="6"></textarea>
		  </div>
		 	
		  <button id="btn" type="button" class="btn btn-primary">ADD</button>
		</form>
	
</div>
<script type="text/javascript" src="../resources/js/boardCheck.js"></script>
</body>
</html>