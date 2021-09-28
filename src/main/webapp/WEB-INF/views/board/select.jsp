<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
<style type="text/css">
	.more{
		cursor: pointer;
	}
</style>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	
	<div class="container-fluid col-md-8">
	<h1>${board}Select Page</h1>
		<h3>NUM:${dto.num}</h3>
		<h3>Title:${dto.title}</h3>
			
			<div>
				${dto.contents}				
			</div>
			
		<h3>Writer:${dto.writer}</h3>
		<h3>DATE:${dto.regDate}</h3>
		<h3>HITS:${dto.hits}</h3>
	
	<c:forEach items="${dto.files}" var="f">
		<div>
		<a href="./down?fileName=${f.fileName}">${f.oriName}</a>		
		</div>
	</c:forEach>	
	<hr />
	<hr>
	<hr>	
	<hr>
	<form action="./comment">
	
	</form>
	
	<hr>	
	<!-- comment list ---- select페이지에 출력될 댓글 목록들 -->
	<div id="commentList" data-board-num="${dto.num}">
	
	
	</div>
	
	<div>
	  <div class="mb-3">
		    <label for="writer" class="form-label">Writer</label>
		    <input type=text" class="form-control" name="writer" id="writer" value="${member.id}" readonly >
		 	<div id="w_1" class="er"></div>
		  </div>
		  
		  <div class="mb-3">
		   <label for="contents" class="form-label">Contents</label>
  			<textarea class="form-control" cols=""  name="contents" id="contents" rows="6"></textarea>
		  </div>
		  
		  
		 <!--  button 추가 -->
		 <button type="button" id="comment" class="btn btn-danger">댓글달기</button>
	
	</div>
		
	<hr>	
		
	<c:if test="${not empty member and member.id eq dto.writer}">
	<a href="./delete?num=${dto.num}">DELETE</a>
	<a href="./update?num=${dto.num}">UPDATE</a>
	</c:if>
	<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}">REPLY</a>
	</c:if>
	</div>

<!-- 댓글 목록들 출력 자바스크립트 09-23 -->
<script type="text/javascript">
	getCommentList(1);	//1: 첫페이지를 뜻함
	
	//전역변수 선언
	let content='';

	//update 	부모 			위임
	$('#commentList').on("click", ".commentUpdate", function(){
		console.log('update');
		let num = $(this).attr("data-comment-update");	//가져올 속성명
		content= $("#content"+num).text().trim();
		$("#content"+num).children().css('display', 'none');	//
		let ta = '<textarea class="form-control" cols=""  name="contents" id="contents" rows="6">'
		ta = ta+content.trim() + '</textarea>';
		ta = ta + '<button type="button" id="comment" class="btn btn-primary up">업데이트</button>'
		ta = ta + '<button type="button" id="comment" class="btn btn-danger cancel">취소</button>'
		$("#content"+num).append(ta);	//버튼 넣기
	});
	
	//댓글 수정 update
	$("#commentList").on('click', '.up', function(){
		let contents = $(this).prev().val();
		let cn = $(this).parent().prev().text().trim();
		let selector=$(this);
		$.ajax({
			type:"POST",
			url: "./commentUpdate",
			data:{				
				commentNum:cn,
				contents:contents
			},
			success:function(result){
				if(result.trim()>0){
					alert('수정 성공');
					//getCommentList(1);
					selector.parent().children('div').text(contents);
					selector.parent().children('div').css('display', 'block');
					selector.parent().children('textarea').remove();
					selector.parent().children('button').remove();
				}else{
					alert('수정 실패');
				}
			},
			error:function(){
				alert('수정 실패');
			}
			
		});
	});
	
	
	// 09-24 cancel
	$("#commentList").on('click', ".cancel", function(){
		console.log(content);
		//1) textarea 없애기
		$(this).parent().children('div').css('display', 'block');
		$(this).parent().children('textarea').remove();
		$(this).parent().children('button').remove();
		//2) 원래 있던 내용 가져오기
		
	})
	
	
	//Del click event
	$('#commentList').on("click", ".commentDel", function(){
		let commentNum = $(this).attr("data-comment-del");
		console.log(commentNum);
		//url ./commentDel
		$.ajax({
			type: "POST",
			url: "./commentDel",
			data: {
				commentNum:commentNum
			},
			success:function(result){
				result=result.trim();
				
				if(result>0){
					alert("삭제 성공");
					getCommentList(1);
				}else{
					alert("삭제 실패");
				}
				
			},
			error:function(){
				alert('삭제 실패');
			}
		});
	});
	
	//이벤트 위임
	$("#commentList").on("click", ".more", function(){
		//data-comment-pn 값을 출력
		let pn = $(this).attr("data-comment-pn");
		getCommentList(pn);
		//console.log(pn);
	});
	
	
	
	function getCommentList(pageNumber){
		let num = $("#commentList").attr("data-board-num");
		
		$.ajax({
			type: "get",
			url: "./getCommentList",
			data: {
				num:num,
				pn : pageNumber	
			},	//파라미터이름:변수명
			success: function(result){
				//result=result.trim();
				console.log(result);
				$("#commentList").html(result);
			},
			error: function(xhr, status, error){
				console.log(error);
			}
			
		});
	}

</script>


<!-- 댓글 작성 버튼 입력시 -->
<script type="text/javascript">
	$("#comment").click(function(){
		//작성자, 내용을 콘솔에 출력
		let writer = $("#writer").val();
		let contents = $("#contents").val();
		$.post("./comment", {num:'${dto.num}', writer:writer, contents:contents}, function(result){
			alert(result);
			console.log(result);
			
			$("#contents").val('');
			getCommentList();
		});
		
	});
</script>
	
	
<script type="text/javascript" src="../resources/js/select.js"></script>
</body>
</html>