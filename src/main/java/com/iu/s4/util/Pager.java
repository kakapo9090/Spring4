package com.iu.s4.util;

public class Pager {
	
	
	
	//1.파라미터 처리
	private Long pn;	//현재 페이지, 레퍼런스타입, 기본값 null을 가짐
	
	//2.한 페이지 출력할 행의 갯수(DB에서 사용)
	private Long perPage;	//기본값 10
	
	//한 페이지에 출력할 pn의 갯수 [<}  [1] [2] [3] [4] [5]  [>}
	private Long perBlock;	//기본값 5
	
	//-------- RowNum ---- --------- 매퍼에서 파라미터로 사용
	private Long startRow;
	private Long lastRow;
	
	//-------- startNum, lastNum	jsp에서 사용
	private Long startNum;
	private Long lastNum;
	
	private Long totalPage;
	
	
	// --------- 검색 변수 ----------------------
	private String kind;
	private String search;
	
	
	
	

	// --------- RowNum 계산		현재 페이지pn을 이용
	public void makeRow() {
		this.startRow=(this.getPn()-1) * this.getPerPage() +1;
		this.lastRow=this.getPn() * this.getPerPage();
	}
	
	//	--------- startNum, lastNum     Jsp에서 번호 출력
	public void makeNum(Long totalCount){
		//1. totalCount : 전체 글(행)의 개수	ex) 21
		//2. totalCount로 totalPage 계산(전체 페이지 번호) ex) [1] [2] [3]
		totalPage = totalCount / this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		
		//3. totalPage로 totalBlock 계산
		Long totalBlock = totalPage / this.getPerBlock();
		if(totalPage % this.getPerBlock() != 0) {
			totalBlock++;
		}
		//3-1. pn으로 curBlock 구하기
		if(totalPage < this.getPn()) {
			this.setPn(totalPage);
			//this.pn = totalPage;
		}//마지막번호를 초과한경우 마지막번호로 고정시키기
		
		//4. pn으로 현재 블럭 번호 구하기
		Long curBlock = this.getPn() / this.getPerBlock();
		if(this.getPn() % this.getPerPage() != 0) {
			curBlock++;
		}
		
		//5. curBlock으로 startNum, lastNum 계산	1, 5	6, 10 ...
		this.startNum = (curBlock-1) * this.getPerBlock() +1;
		this.lastNum = curBlock * this.getPerBlock();
	
		//6. curBlock이 마지막 block일 때 lastNum 변경
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
	}
	
	
//--------setter getter ------
	
	
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}


	public Long getStartRow() {
		return startRow;
	}


	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}


	public Long getLastRow() {
		return lastRow;
	}


	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getPerBlock() {	//블록 하나당 몇 페이지를 가질것인가
		this.perBlock=5L;
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}


	public Long getPn() {
		if(this.pn == null || this.pn < 1) {
			this.pn=1L;
		}
		return pn;
	}
	

	public void setPn(Long pn) {
		this.pn = pn;
	}
	
	public Long getPerPage() {
		if(this.perPage == null || this.perPage < 1) {
			this.perPage=10L;
		}
		return perPage;
	}
	
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
}
