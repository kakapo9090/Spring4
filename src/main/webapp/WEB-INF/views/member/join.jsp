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
	<h1>Join Page</h1>

	
<form id="frm" class="col-md-4 mx-auto" action="join" method="post" enctype="multipart/form-data">
	<span class="d-block p-2 bg-dark text-white" style="text-align: center;">회원가입</span>
	<br>
	
	
  <div class="mb-3">
    <label for="id1" class="form-label">ID 입력</label>
    <input type="text" name="id" class="form-control put" id="id" >
    <button id="idCheck" type="button">ID중복확인</button>
    <div id="idResult"></div>
  </div>
  
  <div class="mb-3">
    <label for="pw1" class="form-label">Password 입력</label>
    <input type="password" name="pw" class="form-control put pw" id="pw1">
  </div>
  <div class="mb-3">
    <label for="pw2" class="form-label">Password 확인</label>
    <input type="password" name="pw2" class="form-control put pw" id="pw2">
  </div>
  
   <div class="mb-3">
    <label for="name1" class="form-label">이름</label>
    <input type="text" name="name" class="form-control put" id="name1" placeholder="홍길동">
  </div>
  
  <div class="mb-3">
    <label for="phone1" class="form-label">연락처</label>
    <input type="tel" name="phone" class="form-control put" id="phone1">
  </div>

  <div class="mb-3">
    <label for="email1" class="form-label">Email address 입력</label>
    <input type="email" name="email" class="form-control put" id="email1" placeholder="hongildong@korean.com">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  
  <button id="btn1" type="submit" class="btn btn-primary">가입하기</button>
  


	
   <div class="mb-3" id="f">
    <label for="photo" class="form-label">Photo</label>
    <input type="file" name="photo" class="form-control put" id="photo" >
  </div>
  
</form>
	
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- <script type="text/javascript" src="../resources/js/join.js"></script>	
<script type="text/javascript" src="../resources/js/file.js"></script>	 -->
</body>
</html>