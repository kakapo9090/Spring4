package com.iu.s4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;
import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	
	//매개변수로 삭제할 글 번호를 받는다
	@GetMapping("delete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setDelete(boardDTO);
		
		ModelAndView mv = new ModelAndView();
		String message="DELETE FAIL";
		if(result>0) {
			message="DELETE SUCCESS";
		}
		
		//result.jsp에서 출력할 메시지 보내기
		mv.addObject("msg", message);	//메시지
		mv.addObject("url", "./list");	//url값을 보낼수도있음
		
		mv.setViewName("common/result");
		return mv;
		
	}
	
	
	
	//09-16 게시물 글 + 이미지 출력
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		List<BoardFilesDTO> ar = noticeService.getFiles(boardDTO); //글번호 넘겨주기
		mv.addObject("fileList", ar);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/select");
		return mv;
	}
	
	
	@GetMapping("insert")
	public ModelAndView setInsert()throws Exception{
		System.out.println("test");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/insert");
		return mv;
	}
	//09-15 파일 업로드
	@PostMapping("insert")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile [] files)throws Exception{
		//original file name 출력
		for(MultipartFile muFile: files) {
			System.out.println(muFile.getOriginalFilename());
		}
		
		
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardDTO, files);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	//@RequestMapping(value = "list", method = RequestMethod.GET)
	@GetMapping("list")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		
		List<BoardDTO> ar = noticeService.getList(pager);
		
		//jsp로 오브젝트 보내기
		mv.addObject("list", ar);	
		mv.addObject("pager", pager);
		return mv;
	}
	
}
