package com.thigpen.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thigpen.languages.models.Language;
import com.thigpen.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
//	returns all languages
	public List<Language> allLanguages() {
		return this.languageRepository.findAll();
	}
	
//	create a new language
	public Language createLang(Language language) {
		return this.languageRepository.save(language);
	}
	
//	find a language by given id
	public Language findOneLang(Long id) {
		return this.languageRepository.findById(id).orElse(null);
	}
	
//	delete a Language
	public void deleteLang(Long id) {
		this.languageRepository.deleteById(id);
	}
	
	
//	update a Language
	public Language updateLang(Language lang) {
		return this.languageRepository.save(lang);
	}
	
	public Language updateLang(Long id, String name, String creator, String currentVersion) {
		Language lang = this.findOneLang(id);
		
		lang.setName(name);
		lang.setCreator(creator);
		lang.setCurrentVersion(currentVersion);
		
		return this.languageRepository.save(lang);
	}
	
}


	
