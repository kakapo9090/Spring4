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
	<h1>Login Page</h1>
	
<form id="frm" class="col-md-4 mx-auto" action="login" method="post">
	<span class="d-block p-2 bg-dark text-white" style="text-align: center;">로그인</span>
	<br>
	
  <div class="mb-3">
    <label for="id1" class="form-label">ID 입력</label>
    <input type="text" name="id" class="form-control put" id="id" >
  </div>
  
  <div class="mb-3">
    <label for="pw1" class="form-label">Password 입력</label>
    <input type="password" name="pw" class="form-control put pw" id="pw1">
  </div>
  <button>LOGIN</button>
</form>
</body>
</html>