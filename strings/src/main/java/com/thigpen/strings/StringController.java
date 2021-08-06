package com.thigpen.strings;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {
	
	@RequestMapping("/")
	public String home() {
		return "Hello Client, How are you doing?";
	}

	@RequestMapping("/random")
	public String random() {
		return "Spring Boot is soooooo great";
	}
}
