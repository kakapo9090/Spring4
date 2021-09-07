package com.iu.s4.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s4.board.BoardDAO;
import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.qna.QnaDTO;
import com.iu.s4.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s4.board.notice.NoticeDAO.";
	
	
	
	

	@Override
	public Long getCount(Pager pager) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getCount", pager);
	}

	@Override //나중에 파라미터로 pager넣기 완
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getSelect", boardDTO);
	}

	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"setHitUpdate", boardDTO);
	}
	
	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setInsert", boardDTO);
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
	
	// 답글 qna에만 있는 메서드
	public int setReply(QnaDTO qnaDTO) throws Exception{
		return 0;
	}
	
}
