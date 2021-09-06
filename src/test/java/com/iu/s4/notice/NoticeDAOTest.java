package com.iu.s4.notice;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s4.MyJunitTest;

public class NoticeDAOTest extends MyJunitTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	
	//@Test
	public void getListTest() {
		List<NoticeDTO> ar = noticeDAO.getList();
		assertNotEquals(0, ar.size());
	}
	//@Test
	public void getSelectTest() {
		 NoticeDTO noticeDTO = new NoticeDTO();
		 noticeDTO.setNum(3);
		 noticeDTO = noticeDAO.getSelect(noticeDTO);
		 assertNotNull(noticeDTO);
	}
	
	//@Test
	public void setInsertTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("제목 테스트6");
		noticeDTO.setContents("내용 테스트6");
		noticeDTO.setWriter("작성자 테스트6");
		int result = noticeDAO.setInsert(noticeDTO);
		assertNotEquals(0, result);
	}
	
	//@Test
	public void setDeleteTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(22);
		int result = noticeDAO.setDelete(noticeDTO);
		assertNotEquals(0, result);	
	}
	@Test
	public void setUpdateTest() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(26L);
		noticeDTO.setTitle("hello");
		noticeDTO.setContents("abcdefg");
		noticeDTO.setWriter("PARK");
		int result = noticeDAO.setUpdate(noticeDTO);
		assertNotEquals(0, result);
	}
	
}
