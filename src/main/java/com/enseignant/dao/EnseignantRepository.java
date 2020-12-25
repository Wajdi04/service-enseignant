package com.enseignant.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.enseignant.entities.Enseignant;

@RepositoryRestResource
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

	public Page<Enseignant> findAll(Pageable page);
	
	public Page<Enseignant> findByNomContains(String nom, Pageable page);	
	public Page<Enseignant> findByPrenomContains(String prenom, Pageable page);	
	public Page<Enseignant> findByGradeContains(String grade, Pageable page);	
	public Page<Enseignant> findByDateEmbaucheBetween(Date begin, Date end, Pageable page);		

}
