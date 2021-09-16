package com.iu.s4.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@PostMapping("update")
	public ModelAndView setUpdate(MemberDTO memberDTO, HttpSession session)throws Exception{
		//수정전 데이터
		MemberDTO sessionDTO = (MemberDTO)session.getAttribute("member");
		
		//수정된 데이터
		memberDTO.setId(sessionDTO.getId());
		
		int result = memberService.setUpdate(memberDTO);
		
		memberDTO.setName(sessionDTO.getName());
		
		session.setAttribute("member", memberDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setUpdate()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/update");
		return mv;
	}
	
	//회원 탈퇴
	@GetMapping("delete")
	public ModelAndView setDelet(HttpSession session) throws Exception{
		//세션의 정보DTO값 가져오기
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result= memberService.setDelete(memberDTO);
		//session.invalidate();	//세션강제 종료
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./logout");	//또는 로그아웃 페이지로 리다이렉트
		return mv;
	}
	
	
	//마이페이지
	@GetMapping("mypage")
	public ModelAndView mypage(HttpSession session) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		MemberFilesDTO memberFilesDTO = memberService.getFile(memberDTO);
		
		ModelAndView mv = new ModelAndView();
		//mv.addObject("files", memberFilesDTO); //09-16 주석 처리
		mv.setViewName("member/mypage");
		return mv;
	}
	
	
	//로그아웃
	@GetMapping("logout")
	public ModelAndView logout (HttpSession session) throws Exception{
		//1.세션 어트리뷰트 삭제
		//session.removeAttribute("member");
		
		//2. 세션의 시간을 0으로 만들어 강제로 죽이기 많이씀
		session.invalidate();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	
	
	//로그인 - DB의 id,pw값과 입력한 파라미터값이 일치하는지 검사
	@PostMapping("login")
	public ModelAndView login(MemberDTO memberDTO, HttpSession session) throws Exception{
		//HttpSession session =request.getSession();
		ModelAndView mv = new ModelAndView();		
		memberDTO = memberService.getLogin(memberDTO);
		if(memberDTO != null) {		// null인 이유 : DB에 없는 값을 SQL로 조회하면 null이 나와서
			System.out.println("로그인 성공");
			session.setAttribute("member", memberDTO); 	// 세션 (키 이름, 밸류 값)
		}else {
			System.out.println("로그인 실패");
		}
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
	//로그인 페이지
	@GetMapping("login")
	public ModelAndView login()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;
	}
	
	//id 중복체크
	@GetMapping("idCheck")
	public ModelAndView getIdCheck(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getIdCheck(memberDTO);
		System.out.println("id 중복체크");
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/idCheck");
		
		return mv;
	}
	
	//회원가입
	@GetMapping("join")
	public ModelAndView join()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		return mv; 
	}
	
	//회원가입 양식 제출
	@PostMapping("join")
	public ModelAndView join(MemberDTO memberDTO, MultipartFile photo, HttpSession session)throws Exception{
		
		/*
		 * String original = photo.getOriginalFilename(); //파일 이름
		 * System.out.println("Original : "+original); String name = photo.getName();
		 * //파라미터 이름 System.out.println("name : "+name); long size = photo.getSize();
		 * //파일 사이즈 System.out.println("FileSize : "+size);
		 */
		
		
		ModelAndView mv = new ModelAndView();
		int result = memberService.setJoin(memberDTO, photo, session);
		
		String message = "회원가입 실패";
		if(result>0) {
			message = "회원가입 성공";
		}
		
		mv.addObject("msg", message);
		mv.addObject("url", "../");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	
	//약관 체크
	@GetMapping("check")
	public ModelAndView check()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/check");
		return mv; 
	}
	
	
}
