package com.iu.s4.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s4.notice.NoticeDAO.";
	
	public List<NoticeDTO> getList() {
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) {
		//System.out.println("테스트 메시지 DAO : "+noticeDTO.getNum());
		return sqlSession.selectOne(NAMESPACE+"getSelect", noticeDTO);
	}
	
	public int setInsert(NoticeDTO noticeDTO) {
		return sqlSession.insert(NAMESPACE+"setInsert", noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) {
		return sqlSession.delete(NAMESPACE+"setDelete", noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) {
		return sqlSession.update(NAMESPACE+"setUpdate", noticeDTO);	
	}
	
}
