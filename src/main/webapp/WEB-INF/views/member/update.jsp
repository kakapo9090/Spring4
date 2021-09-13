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
	<h1>Update Page</h1>

	
<form id="frm" class="col-md-4 mx-auto" action="update" method="post">
	<span class="d-block p-2 bg-dark text-white" style="text-align: center;">회원가입</span>
	<br>
	

	  <div class="mb-3">
	    <label for="pw1" class="form-label">Password 입력</label>
	    <input type="password" name="pw" value="${member.pw}" class="form-control put pw" id="pw1">
	  </div>
	  <div class="mb-3">
	    <label for="pw2" class="form-label">Password 확인</label>
	    <input type="password" name="pw2" class="form-control put pw" id="pw2">
	  </div>
	  
	  
	  <div class="mb-3">
	    <label for="phone1" class="form-label">연락처</label>
	    <input type="tel" name="phone" value="${member.phone}" class="form-control put" id="phone1">
	  </div>
	
	  <div class="mb-3">
	    <label for="email1" class="form-label">Email address 입력</label>
	    <input type="email" name="email" value="${member.email}" class="form-control put" id="email1" placeholder="hongildong@korean.com">
	    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
	  </div>
	  
	  <button id="btn1" type="submit" class="btn btn-primary">UPDATE</button>
</form>
	
	

<script type="text/javascript" src="../resources/js/join.js"></script>	
</body>
</html>