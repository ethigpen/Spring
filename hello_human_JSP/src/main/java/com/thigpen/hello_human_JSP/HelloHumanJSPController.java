package com.thigpen.hello_human_JSP;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloHumanJSPController {

	@RequestMapping("/")
	public String home() {
		
			return "index.jsp";
	}
	

}
