package com.iu.s4.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s4.board.BoardDAO;
import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;
import com.iu.s4.board.CommentsDTO;
import com.iu.s4.board.qna.QnaDTO;
import com.iu.s4.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s4.board.notice.NoticeDAO.";
	
	//BoardDAO선언하고 오버라이딩해야함
	//댓글 작성 09-23
	public int setComment(CommentsDTO commentsDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setComment", commentsDTO);
			
	}
	
	//BoardDAO선언하고 오버라이딩해야함
	//파일 출력 메서드 09-15
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getFiles", boardDTO);
	}
	
	//파일 업로드 메서드 09-15
	@Override
	public int setFile(BoardFilesDTO boardFilesDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"setFile", boardFilesDTO);
	}
	
	

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
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
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
