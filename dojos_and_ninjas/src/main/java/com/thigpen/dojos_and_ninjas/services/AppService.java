package com.thigpen.dojos_and_ninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thigpen.dojos_and_ninjas.models.Dojo;
import com.thigpen.dojos_and_ninjas.models.Ninja;
import com.thigpen.dojos_and_ninjas.repositories.DojoRepository;
import com.thigpen.dojos_and_ninjas.repositories.NinjaRepository;

@Service
public class AppService {
	
	private final NinjaRepository ninjaRepo;
	private final DojoRepository dojoRepo;
	
	public AppService(NinjaRepository ninjaRepo,DojoRepository dojoRepo) {
		this.ninjaRepo = ninjaRepo;
		this.dojoRepo = dojoRepo;
	}

	
//	All the methods
	
	public List<Dojo> findAllDojos(){
		return (List<Dojo>)this.dojoRepo.findAll();
	}
	
	public Dojo createDjo(Dojo d) {
		return this.dojoRepo.save(d);
	}
	
	
	public Ninja createNinja(Ninja n) {
		return this.ninjaRepo.save(n);
	}
	
	public Dojo getOneDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}

}
