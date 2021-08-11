package com.thigpen.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.thigpen.languages.models.Language;
import com.thigpen.languages.services.LanguageService;

@Controller
public class LanguageController {

	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/languages")
	public String getAllLangs(Model model, @ModelAttribute("lang") Language lang){
		List<Language> allLangs = this.languageService.allLanguages();
		
		model.addAttribute("allLangs", allLangs);
		return "index.jsp";
		
	}
	
	@PostMapping("/languages/create")
	public String createLang(@Valid @ModelAttribute("lang") Language lang, BindingResult result) {
		if(result.hasErrors()) {
			return"index.jsp";
		}
		this.languageService.createLang(lang);
		
		return "redirect:/languages";
	}
	
	@GetMapping("/languages/{id}")
	public String showLang(@PathVariable("id") Long id, Model model) {
		
		Language l = this.languageService.findOneLang(id);
		model.addAttribute("lang",l);
		
		return "showlang.jsp";
	}
	
	
	@GetMapping("/languages/edit/{id}")
	public String editLang(@PathVariable("id") Long id, Model model) {
		
		Language lang = this.languageService.findOneLang(id);
		model.addAttribute("lang",lang);
		
		return "editlang.jsp";
	}
	
	@PostMapping("/languages/update/{id}")
	public String updateLang(@PathVariable("id") Long id, @Valid @ModelAttribute("lang") Language lang, BindingResult result) {
		
		if(result.hasErrors()) {
			return "editlang.jsp";
		}
		
		this.languageService.updateLang(lang);
		return "redirect:/languages";
	}
	
	@GetMapping("/languages/delete/{id}")
	public String deleteLang(@PathVariable("id") Long id) {
		this.languageService.deleteLang(id);
		
		return "redirect:/languages";
	}
	
	
}
