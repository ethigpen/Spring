package com.thigpen.dojo_survey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String survey() {
		return "dojoSurvey.jsp";
	}
	
	@PostMapping("/result")
	public String create(@RequestParam("name") String name, @RequestParam("location") String location,@RequestParam("language") String language, @RequestParam("comment") String comment, Model model) {
		
		model.addAttribute("name", name); 
		model.addAttribute("location", location);
		model.addAttribute("lang", language);
		model.addAttribute("comment", comment);
		
		return "result.jsp";
	}
	

}
