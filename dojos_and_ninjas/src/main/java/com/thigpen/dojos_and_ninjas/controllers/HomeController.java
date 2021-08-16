package com.thigpen.dojos_and_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.thigpen.dojos_and_ninjas.models.Dojo;
import com.thigpen.dojos_and_ninjas.models.Ninja;
import com.thigpen.dojos_and_ninjas.services.AppService;

@Controller
public class HomeController {

//gotta know the services
	
	private final AppService appService;
	
	public HomeController(AppService appService) {
		this.appService= appService;
	}
	
	
		@GetMapping("/dojos/new")
		public String home(@ModelAttribute("dojo") Dojo dojo) {
			return "newdojo.jsp";
		}
		
		@PostMapping("/dojos/create")
		public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
			if(result.hasErrors()) {
				return "newdojo.jsp";
			}else {
				this.appService.createDjo(dojo);
				return "redirect:/dojos/new";
			}			
		}
		
		@GetMapping("/ninjas/new")
		public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
			
			List<Dojo> allDojos = this.appService.findAllDojos();
			model.addAttribute("allDojos", allDojos);
			
			return"newninja.jsp";
		}
		
		@PostMapping("/ninjas/create")
		public String createNinja(@Valid @ModelAttribute("ninja") Ninja  ninja, BindingResult result, Model model ) {
			if(result.hasErrors()) {
				List<Dojo> allDojos = this.appService.findAllDojos();
				model.addAttribute("allDojos", allDojos);
				
				return "newninja.jsp";
			}else {
				this.appService.createNinja(ninja);
				
				return "redirect:/ninjas/new";
			}
		}
			
			@GetMapping("/dojos/{id}")
			public String showDojosNinjas(@PathVariable("id")Long id, Model model) {
				
				Dojo d = this.appService.getOneDojo(id);
				model.addAttribute("dojo", d);
				
				return "showdojo.jsp";
			}
			
			
		
		
		
		
}
