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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
<h1>Check Page</h1>

<div class="container-fluid">
	<div class="form-check">
	  <input class="form-check-input" type="checkbox" value="" id="all">
	  <label class="form-check-label" for="all">
	    Check ALL
	  </label>
	</div>
	
	<div class="form-check">
	  <input class="form-check-input checks pilsu" type="checkbox" value="" id="cb">
	  <label class="form-check-label" for="flexCheckDefault">
	    약관1(필수)
	  </label>
	</div>
	
	<div class="form-check">
	  <input class="form-check-input checks pilsu" type="checkbox" value="" id="cb">
	  <label class="form-check-label" for="flexCheckDefault">
	    약관2(필수)
	  </label>
	</div>
	
	<div class="form-check">
	  <input class="form-check-input checks pilsu" type="checkbox" value="" id="cb">
	  <label class="form-check-label" for="flexCheckDefault">
	    약관3(필수)
	  </label>
	</div>
	
	<div class="form-check">
	  <input class="form-check-input checks" type="checkbox" value="" id="cb">
	  <label class="form-check-label" for="flexCheckDefault">
	    약관4 마케팅 수신 동의(선택)
	  </label>
	</div>

	<button id="btn">회원가입</button>
	<!-- <a href="./join" id="btn">회원가입</a>   a태그는 안됨. -->
</div>

<script type="text/javascript" src="../resources/js/member.js"></script>
</body>
</html>