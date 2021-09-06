package com.iu.s4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardService;
@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	
	@Override
	public List<BoardDTO> getList() throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getList();
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

}
