package com.thigpen.dojos_and_ninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thigpen.dojos_and_ninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository <Dojo, Long> {

}
