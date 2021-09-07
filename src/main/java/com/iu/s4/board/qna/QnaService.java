package com.iu.s4.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardService;
import com.iu.s4.util.Pager;
@Service
public class QnaService implements BoardService {
	@Autowired
	private QnaDAO qnaDAO;
	
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setInsert(boardDTO);
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

	
	public int setReply(QnaDTO qnaDTO) throws Exception{
		//1. 부모의 정보(num) 조회
		System.out.println("Qna서비스Num : " + qnaDTO.getNum());
		QnaDTO parent = (QnaDTO)qnaDAO.getSelect(qnaDTO);	//강제 형변환
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		
		//2. update
		int result = qnaDAO.setReplyUpdate(parent);
		
		
		//3. insert
		result = qnaDAO.setReply(qnaDTO);
		
		
		return result;
	}
}
