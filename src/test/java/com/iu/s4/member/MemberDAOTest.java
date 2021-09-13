package com.iu.s4.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s4.MyJunitTest;

public class MemberDAOTest extends MyJunitTest{
	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void getIdCheck() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("iu22222");
		memberDTO = memberDAO.getIdCheck(memberDTO);
		assertNotNull(memberDTO);
	}

	
	@Test
	public void setJoin() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("korean1234");
		memberDTO.setPw("1234");
		memberDTO.setName("한국인");
		memberDTO.setPhone("3496346323532");
		memberDTO.setEmail("asdaddasd@ddsg.com");
		
		int result = memberDAO.setJoin(memberDTO);
		assertNotEquals(0, result);
		
	}
	
}
