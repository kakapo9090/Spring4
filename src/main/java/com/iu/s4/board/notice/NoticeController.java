package com.iu.s4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.board.BoardDTO;
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
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
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
	@PostMapping("insert")
	public ModelAndView setInsert(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardDTO);
		
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
