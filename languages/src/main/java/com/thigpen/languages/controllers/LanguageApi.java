package com.thigpen.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thigpen.languages.models.Language;
import com.thigpen.languages.services.LanguageService;



@RestController
public class LanguageApi {
	
	private final LanguageService languageService;
	
	public LanguageApi(LanguageService languageService) {
		this.languageService = languageService;
	}
	
//	controller to look at all the languages
	@RequestMapping("/api/languages")
	public List<Language> getAllLangs(){
		return this.languageService.allLanguages();
	}
	
//	to create a language
	@PostMapping("/api/languages")
	public Language createNewLang(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion) {
		
		Language lang = new Language(name,creator,currentVersion);
		return this.languageService.createLang(lang);
	}
	
//	get one language based on an id
	@GetMapping("/api/languages/{id}")
	public Language findALang(@PathVariable("id") Long id) {
		return this.languageService.findOneLang(id);
	}
	
	@GetMapping("/api/languages/delete/{id}")
	public void deleteLang(@PathVariable("id") Long id) {
		this.languageService.deleteLang(id);
	}
	
	@PutMapping("/api/languages/update/{id}")
	public Language updateLang(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion) {
		return this.languageService.updateLang(id, name, creator, currentVersion);
	}
	

}
