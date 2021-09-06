package com.iu.s4.board.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	//@RequestMapping(value = "list", method = RequestMethod.GET)
	@GetMapping("list")
	public void getList()throws Exception{
		
	}
	
}
