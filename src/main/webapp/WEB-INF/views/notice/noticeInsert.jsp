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
<h1>Notice Insert Page</h1>

<div class="container-fluid">
	<form class="col-md-5 mx-auto" action="./noticeInsert" method="post">
		<div class="mb-3">
 			 <label for="title" class="form-label">제목</label>
 			 <input type="text" class="form-control" name="title" id="title" placeholder="제목입력란">
		</div>
		
		<div class="mb-3">
 			 <label for="contents" class="form-label">내용</label>
 			 <input type="text" class="form-control" name="contents" id="contents" placeholder="내용입력란">
		</div>
	
		<div class="mb-3">
 			 <label for="writer" class="form-label">작성자</label>
 			 <input type="text" class="form-control" name="writer" id="writer" placeholder="작성자명">
		</div>

		<button type="submit" class="btn btn-success">ADD</button>
	</form>


</div>

</body>
</html>