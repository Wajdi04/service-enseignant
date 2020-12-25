package com.enseignant.metier;


import java.text.ParseException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.enseignant.entities.Enseignant;

public interface EnseignantMetier {
	public Enseignant save(Enseignant e);
	public Page<Enseignant> listEnseignant(Pageable page);
	public Page<Enseignant> findEnseignantByNom(String nom,Pageable page);
	public Page<Enseignant> findEnseignantByPrenom(String prenom,Pageable page);
	public Page<Enseignant> findEnseignantByGrade(String grade,Pageable page);
	public Page<Enseignant> findEnseignantByDateEmbauche(String begin,String end,Pageable page) throws ParseException;
	public Enseignant findByID(Long id);
	public Enseignant deleteEnseignant(Long id);
	public ResponseEntity<Enseignant> updateEnseignant(Long id, Enseignant e);


}
