# Spring4

## Board

### Notice

1. 	글번호  글제목, 글내용, 작성자, 작성일, 조회수
	 1		a		a		a	오늘		0
	 2		a		a		a	오늘		0	
	
	
1. 테이블 생성
	NOTICE
	NUM
	TITLE
	CONTENTS	:	textarea
	WRITER
	REGDATE
	HITS

2. Notice Sequence   이름_SEQ, start with 1 
3. 기능 
	1) List
	주소:	/notice/list
			/WEB-INF/views/board/list.jsp
	2) 상세보기
	주소:	/notice/select?num=value
			/WEB-INF/views/board/select.jsp	
	3) 글쓰기
			/notice/insert 	GET
			/WEB-INF/views/board/insert.jsp
			/notice/insert	POST
			/list
	4) 삭제
	상세보기에 링크 /notice/delete	GET
				/list로 돌아감
	
	5) 수정
	
4. 순서
	1)	DTO, DAO, MAPPER, TEST CASE 테스트 수행
	2)  Service, Controller, JSP 연결
	
	
CLOB	java.lang.String
DATE	java.sql.Date