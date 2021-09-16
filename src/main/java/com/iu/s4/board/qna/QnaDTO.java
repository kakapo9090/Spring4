package com.iu.s4.board.qna;

import java.util.List;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;

public class QnaDTO extends BoardDTO {
	//is a
	//has a
		
	
	private Long ref;
	private Long step;
	private Long depth;
	
	//qnaFilesDTO가 여러개일 수 있다
	private List<BoardFilesDTO> files;
	
	public List<BoardFilesDTO> getFiles() {
		return files;
	}
	public void setFiles(List<BoardFilesDTO> files) {
		this.files = files;
	}
	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	
	
}
