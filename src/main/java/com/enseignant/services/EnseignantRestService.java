package com.enseignant.services;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enseignant.entities.Enseignant;
import com.enseignant.metier.EnseignantMetier;

@RestController
public class EnseignantRestService {

	@Autowired
	private EnseignantMetier enseignantMetier;

	
	@PostMapping(value = "/enseignants")
	public Enseignant save(@RequestBody Enseignant e) {
		return enseignantMetier.save(e);
	}
	
	@GetMapping(value = "/enseignants")
	public Page<Enseignant> listEnseignant(Pageable page) {
		return enseignantMetier.listEnseignant(page);
	}
	
	@GetMapping(value = "/enseignants/{id}")
	public Enseignant getEnseignant(@PathVariable(name = "id") Long id) {	
		return enseignantMetier.findByID(id);
	}
	
	@DeleteMapping(value = "/enseignants/{id}")
	public Enseignant deleteEnseignant(@PathVariable(name = "id") Long id) {	
		return enseignantMetier.deleteEnseignant(id);
	}
	
	@PutMapping(value = "/enseignants/{id}")
	public ResponseEntity<Enseignant> updateEnseignant(@PathVariable(name = "id") Long id,@RequestBody Enseignant e) {
		return enseignantMetier.updateEnseignant(id,e);
	}
	
	
	@GetMapping(value = "/enseignantsByNom")
	public Page<Enseignant> getEnseignantByNom(@RequestParam(name = "nom", defaultValue = "") String nom,
			@RequestParam(name = "page", defaultValue = "0") int  page,
			@RequestParam(name = "size", defaultValue = "5") int size) {	
		return enseignantMetier.findEnseignantByNom(nom, PageRequest.of(page,size));
	}
	
	
	@GetMapping(value = "/enseignantsByPrenom")
	public Page<Enseignant> getEnseignantByPrenom(@RequestParam(name = "prenom", defaultValue = "") String prenom,
			@RequestParam(name = "page", defaultValue = "0") int  page,
			@RequestParam(name = "size", defaultValue = "5") int size) {	
		return enseignantMetier.findEnseignantByPrenom(prenom, PageRequest.of(page,size));
	}
	
	@GetMapping(value = "/enseignantsByGrade")
	public Page<Enseignant> getEnseignantByGrade(@RequestParam(name = "grade", defaultValue = "") String grade,
			@RequestParam(name = "page", defaultValue = "0") int  page,
			@RequestParam(name = "size", defaultValue = "5") int size) {	
		return enseignantMetier.findEnseignantByGrade(grade, PageRequest.of(page,size));
	}
	
	@GetMapping(value = "/enseignantsByDateEmbauche")
	public Page<Enseignant> getEnseignantByDateEmbauche(@RequestParam(name = "begin") String begin ,
			@RequestParam(name = "end") String end,
			Pageable page) throws ParseException {	
		return enseignantMetier.findEnseignantByDateEmbauche(begin, end, page);
	}
}
