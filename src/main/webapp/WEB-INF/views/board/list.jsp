<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Board List Page</h1>
	
	<div class="col-md-7 my-2 mx-auto">	
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">NUM</th>
	      <th scope="col">TITLE</th>
	      <th scope="col">WRITER</th>
	      <th scope="col">REGDATE</th>
	      <th scope="col">HITS</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${list}" var="dto">
		    <tr>
		      <th scope="row">${dto.num}</th>
		      <td><a href="./select?num=${dto.num}">${dto.title}</a></td>
		      <td>${dto.writer}</td>
		      <td>${dto.regDate}</td>
		      <td>${dto.hits}</td>
		    </tr>
	   </c:forEach>
	  </tbody>
	</table>
	
	
	<!-- pager 응용 -->
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
  
    <li class="page-item">
      <a class="page-link" href="./List?pn=&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    
    <li class="page-item">
      <a class="page-link" href="./List?pn=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
        <span aria-hidden="true">&lt;</span>
      </a>
    </li>
    
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
			<li class="page-item"><a class="page-link" href="./List?pn=${n}&kind=${pager.kind}&search=${pager.search}">${n}</a></li>
		</c:forEach>

	<li class="page-item">
      <a class="page-link" href="./List?pn=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
        <span aria-hidden="true">&gt;</span>
      </a>
    </li>	

    <li class="page-item">
      <a class="page-link" href="./List?pn=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
		
		
		<a href="./Insert" class="btn btn-danger">ADD</a>
	
	
</body>
</html>