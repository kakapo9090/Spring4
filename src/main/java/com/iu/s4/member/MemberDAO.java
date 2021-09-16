package com.iu.s4.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s4.member.MemberDAO.";
	
	public MemberFilesDTO getFile(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getFile", memberDTO);
	}
	
	
	//회원정보 변경
	public int setUpdate(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", memberDTO);
	}
	
	//회원 탈퇴
	public int setDelete(MemberDTO memberDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", memberDTO);
	}
	
	
	public int setFileInsert(MemberFilesDTO memberFilesDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setFileInsert", memberFilesDTO);
	}
	
	
	//로그인 id,pw
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", memberDTO);
		
	}
	
	//약관 체크
	public MemberDTO getIdCheck(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getIdCheck", memberDTO);
	}
	
	//회원가입
	public int setJoin(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setJoin", memberDTO);
	}
	
}
