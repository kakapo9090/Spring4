package com.iu.s4.ajaxTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax/*")
public class AjaxTestController {

	@GetMapping("t1")
	public void t1() throws Exception{
		System.out.println("t1 Test");
	}
	
}
