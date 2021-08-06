package com.thigpen.hello_human;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman {
	
	@RequestMapping("/")
	public String home(@RequestParam(value="fname", required=false) String first_name, @RequestParam(value="lname", required=false) String last_name) {
		if (first_name == null) {
			return "<h1>Hello Human!</h1>" + "<p>Welcome to Spring Boot!</p>";
		}else {
			return "<h1>Hello " + first_name + " " + last_name +"!</h1>" + "<p>Welcome to Spring Boot!</p>" + "<a href ='/' >Go Back</a>";
		}

	}

}
