<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ID CHECK PAGE</h1>
	
	<form id="frm" class="col-md-4 mx-auto" action="idCheck" method="get">

	<div>
		${param.id}는 
		<c:if test="${empty dto}">
			사용 가능한 ID
		</c:if>
		<c:if test="${not empty dto}">
			사용 불가능한 ID
		</c:if>
	</div>
		
	  <div class="mb-3">
	    <label for="text" class="form-label">ID 입력</label>
	    <input type="text" name="id" value="${param.id}" class="form-control put" id="id" >
	    <button id="idCheck" type="submit">ID중복확인</button>
	    <c:if test="${empty dto}">
		    <button type="button" id="useId">ID사용</button>
		</c:if>
	  
	  
	  </div>
  	</form>
<script type="text/javascript">
	const useId = document.getElementById('useId');
	useId.addEventListener('click', function(){
		let id = window.document.getElementById('id').value;
		opener.document.getElementById('id').value=id;
		close();
	});
</script>	

</body>
</html>