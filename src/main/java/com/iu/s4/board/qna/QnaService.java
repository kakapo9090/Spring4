package com.iu.s4.board.qna;

import java.util.List;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardService;

public class QnaService implements BoardService {

	@Override
	public List<BoardDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int setReply(BoardDTO boardDTO) throws Exception{
		return 0;
	}
}
