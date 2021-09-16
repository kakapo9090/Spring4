<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>My Page</h1>
	<h1>ID : ${member.id}</h1>
	<h1>Email : ${member.email}</h1>
	<div>
	<img alt="" src="../resources/upload/member/${member.memberFilesDTO.fileName}">
	
	</div>
	
	
	<a href="./update">수정</a>
	<a href="#" id="del">탈퇴</a>
	
	<script type="text/javascript">
		/* const del = document.getElementById("del"); */
		const del = document.querySelector("#del");
		del.addEventListener('click', function(){
			let result = confirm('Delete?');
			if(result){
				location.href="./delete";
			}
		});
	</script>
	
</body>
</html>