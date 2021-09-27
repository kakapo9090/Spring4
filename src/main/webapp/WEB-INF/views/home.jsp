<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
	
<c:import url="./temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="./temp/boot_nav.jsp"></c:import>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	<c:if test="${not empty member}"> 
	<h3>Login이 성공 했을때 보이는 문장</h3>
	</c:if>
	
	<c:if test="${empty member}">
	<h3>Login을 하기전 보이는 문장</h3>
	</c:if>

	<h1>Conflict</h1>

	<h1>Member Branch</h1>
	
	<button id="btn">CLICK</button>
	<div>
		<table id="r"	class="table table-hover">
			<tr>
				<td id="id">ID</td>
				<td id="title">TITLE</td>
				<td id="userId">USERID</td>
			</tr>
			
			
		</table>
	</div>
	
	
	<script type="text/javascript">
		$("#btn").click(function(){
			$.ajax({
				type: "GET",
				url: "http://jsonplaceholder.typicode.com/posts",
				success:function(result){
					alert(result);
					console.log(result);
					console.log(result[0]);
					console.log(result[0].title);
					
					for(v1 of result){
						let v = "<tr>";
						v = v+ "<td>";
						v = v+ v1.id;
						v = v+"</td>"
						v= v+"<td>";
						v= v+v1.title;
						v= v+"</td>";
						v= v+"<td>";
						v= v+ v1.userId;
						v= v+"</td>";
						v= v+"</tr>";
						$("#r").append(v)
						
						
					}
					
					
				/* 	for (var i = 0; i < result.length; i++) {
						console.log(result[i].title);
					} */
				}
				
			});
		})
	</script>
	
</body>
</html>