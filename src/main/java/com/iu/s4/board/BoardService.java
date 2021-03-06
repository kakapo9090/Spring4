package com.iu.s4.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.util.Pager;

public interface BoardService {
	
		//List 인터페이스에서 abstract 생략가능
		public abstract List<BoardDTO> getList(Pager pager) throws Exception;
		
		//상세 인터페이스에서 abstract 생략가능
		public abstract BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
		
		//글쓰기 * 21-9-15 MultipartFile [] 인터페이스 추가
		public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception;
		
		//글삭제
		public int setDelete(BoardDTO boardDTO) throws Exception;
		
		//글수정
		public int setUpdate(BoardDTO boardDTO) throws Exception;
}
