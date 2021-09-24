<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>





<style type="text/css">
	#d1{
		width: 300px;
		height: 300px;
		background-color: yellow;
	}
</style>
</head>
<body>

<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>${board} Update Page</h1>


<div class="container-fluid">
	
		<form id="frm" class="col-md-6 mx-auto" action="./update" method="post" enctype="multipart/form-data">
		  <div class="mb-3">
		    <label for="title" class="form-label">TITLE</label>
		    <input type="text" class="form-control" name="title" value="${dto.title}" id="title" placeholder="Enter Title">
		 	<div id="t_1" class="er"></div>
		  </div>
		  
		  <div class="mb-3">
		    <label for="writer" class="form-label">Writer</label>
		    <input type=text" class="form-control" name="writer" id="writer" value="${member.id}" readonly >
		 	<div id="w_1" class="er"></div>
		  </div>
		  
		  <div class="mb-3">
		   <label for="contents" class="form-label">Contents</label>
  			<textarea class="form-control" cols=""  name="contents" id="contents" rows="6">${dto.contents}</textarea>
		  </div>
		  
		  
		  <!-- 09-24 첨부파일 삭제 ajax활용-->
		  <div>
		  	<c:forEach items="${dto.files}" var="f">
		  		<div>
		  			${f.oriName}	<span class="fileDelete" data-files-num="${f.fileNum}" data-files-name="${f.fileName}">X</span>
		  		</div>	  	
		  	</c:forEach>
		  </div>
		  
		  <hr>
		  <hr>
		  
		  
		 	<!--  button 추가 -->
		 	<button type="button" id="fileAdd" class="btn btn-danger">File ADD</button>
		 	<button type="button" class="del">Delete</button>
		 	<div id="fileAddResult">
		 	
		 	</div>
		 	

		 	<div class="mb-3">
		  <button id="btn" type="submit" class="btn btn-primary">게시물 수정</button>
			</div>
			
		</form>
	
</div>


<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->

<script type="text/javascript" src="../resources/js/boardFile.js"></script>
<script type="text/javascript">
	setCount('${dto.files.size()}');


	//09-24 파일삭제
	$(".fileDelete").click(function(){
		let fileNum = $(this).attr("data-files-num");
		let fileName = $(this).attr("data-files-name");
		let selector = $(this);
		$.ajax({
			type:"POST",
			url:"./fileDelete",
			data: {
				fileNum:fileNum,
				fileName:fileName
			},
			success:function(result){
				console.log(result);
				selector.parent().remove();
				updateCount();
			}
		});
	});

	$('#contents').summernote();


</script>

</body>
</html>