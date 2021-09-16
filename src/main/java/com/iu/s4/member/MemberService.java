package com.iu.s4.member;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private HttpSession session;
	@Autowired
	private ServletContext servletContext;
	
	public MemberFilesDTO getFile(MemberDTO memberDTO)throws Exception{
		return memberDAO.getFile(memberDTO);
	}

	
	public int setUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.setUpdate(memberDTO);
	}
	
	//회원 탈퇴
	public int setDelete(MemberDTO memberDTO)throws Exception{
		//1. 어느 폴더 - 리얼패스가 필요
		String realPath = servletContext.getRealPath("resources/upload/member/");
		
		//2. 어느 파일
		MemberFilesDTO memberFilesDTO = memberDAO.getFile(memberDTO);
		
		//3. 파일 삭제
		File file = new File(realPath, memberFilesDTO.getFileName());
		file.delete();
		return memberDAO.setDelete(memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	public MemberDTO getIdCheck(MemberDTO memberDTO)throws Exception{
		return memberDAO.getIdCheck(memberDTO);
	}
	
	//★회원가입 첨부파일 업로드
	public int setJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception{
		int result = memberDAO.setJoin(memberDTO);
		
		if(photo != null) {
		
		//1. 어느 폴더에 저장할 것인가
		// /resources/upload/member 
		//2. application(ServletContext) 객체로 저장할 실제 경로 구하기
		//ServletContext sContext = this.session.getServletContext();
		String realPath = this.servletContext.getRealPath("/resources/upload/member/");
		System.out.println("realPath : " + realPath);
		
		//3. 폴더 확인
		File file = new File(realPath);
		
		if(!file.exists()) {
			System.out.println("폴더 생성완료");
			file.mkdirs();	//폴더 만들기
		}
		
		//4. 중복되지 않는 파일이름 생성
		//a. 시간(밀리세컨즈)
		//b. UUID
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + photo.getOriginalFilename();
		System.out.println("filename : " + fileName);
		
		//폴더와 파일명 정보
		file = new File(file, fileName);
		
		//5. 폴더에 파일 저장
		//1) MultipartFile의 transferTo 메서드 사용
		//photo.transferTo(file);
		
		//2) Spring의 API FileCopyUtils의 copy 메서드 사용
		FileCopyUtils.copy(photo.getBytes(), file);
		
		MemberFilesDTO memberFilesDTO = new MemberFilesDTO();
		memberFilesDTO.setId(memberDTO.getId());
		memberFilesDTO.setFileName(fileName);
		memberFilesDTO.setOriName(photo.getOriginalFilename());
		result = memberDAO.setFileInsert(memberFilesDTO);
		}
		
		return result;
	}
	
}
