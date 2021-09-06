package com.iu.s4.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping("noticeList")
	public ModelAndView list(ModelAndView mv) {
	
		List<NoticeDTO> ar = noticeService.getList();
		
		mv.addObject("list", ar);
		mv.setViewName("notice/noticeList");

		return mv;
	}
	
	@RequestMapping("noticeSelect")
	public void select(NoticeDTO noticeDTO, Model model) {
		noticeDTO = noticeService.getSelect(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		
	}
	@RequestMapping(value="noticeInsert", method = RequestMethod.GET)
	public void insert() {}
	@RequestMapping(value="noticeInsert", method = RequestMethod.POST)
	public String insert(NoticeDTO noticeDTO) {
		int result = noticeService.setInsert(noticeDTO);
		
		return "redirect:./noticeList/";
	}
	
	
	@RequestMapping(value="noticeDelete", method = RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO) {
		int result = noticeService.setDelete(noticeDTO);
		
		return "redirect:./noticeList/";
	}
	
	@RequestMapping(value="noticeUpdate", method = RequestMethod.GET)
	public ModelAndView update(NoticeDTO noticeDTO) {
		int result = noticeService.setUpdate(noticeDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/noticeUpdate");
		mv.addObject("dto", noticeDTO);
		
		return mv;
	}
	@RequestMapping(value="noticeUpdate", method = RequestMethod.POST )
	public ModelAndView update(NoticeDTO noticeDTO, ModelAndView mv) {
		int result = noticeService.setUpdate(noticeDTO);
		mv.setViewName("redirect:./noticeList");
		return mv;
	}
	
}
