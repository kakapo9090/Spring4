package com.iu.s4.board;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s4.MyJunitTest;
import com.iu.s4.board.notice.NoticeDAO;

public class CommentDAOTest extends MyJunitTest {
	@Autowired
	NoticeDAO noticeDAO;
	
	//서비스 클래스들의 내장객체들을 전부 주석처리 해야 오류발생x
	@Test
	public void test() throws Exception {
		for(int i=0;i<100;i++) {
			CommentsDTO commentsDTO = new CommentsDTO();
			commentsDTO.setNum(442L);
			commentsDTO.setWriter("iu");
			commentsDTO.setContents("comments"+i);
			commentsDTO.setBoard("N");
			
			noticeDAO.setComment(commentsDTO);
			if(i%10==0) {
				Thread.sleep(1000);				
			}
		}
		System.out.println("finish");
	}
	
}
