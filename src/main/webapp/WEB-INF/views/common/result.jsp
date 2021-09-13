<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert('${msg}');
	location.href='${url}';
</script>
</head>
<body>
	<input type="hidden" id="msg" value="${msg}">
<script type="text/javascript" src="../resources/js/result.js"></script>
</body>
</html>