package com.iu.s4.notice;

public class NoticeDTO {
	//멤버변수 Table 컬럼과 같은 데이터타입
	//접근지정자는 private
	//setter getter
	//생성자는 기본생성자
	
	private long num;
	private String title;
	private String contents;
	private String writer;
	private java.sql.Date regDate;
	private long hits;
	
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public java.sql.Date getRegDate() {
		return regDate;
	}
	public void setRegDate(java.sql.Date regDate) {
		this.regDate = regDate;
	}
	public long getHits() {
		return hits;
	}
	public void setHits(long hits) {
		this.hits = hits;
	}
	
}
