package com.iu.s4.board;
//NOTICE & QNA 파일 업로드 관련 상속 없이 사용해보도록함 
public class BoardFilesDTO {
	private Long fileNum;
	private Long num;
	private String fileName;
	private String oriName;
	
	public Long getFileNum() {
		return fileNum;
	}
	public void setFileNum(Long fileNum) {
		this.fileNum = fileNum;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	
	
}
