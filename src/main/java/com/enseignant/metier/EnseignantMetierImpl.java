package com.enseignant.metier;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.enseignant.dao.EnseignantRepository;
import com.enseignant.entities.Enseignant;

@Service
public class EnseignantMetierImpl implements EnseignantMetier {
	
	@Autowired
	private EnseignantRepository enseignantRepository;
	
	@Override
	public Enseignant save(Enseignant e) {
		// TODO Auto-generated method stub
		return enseignantRepository.save(e);
	}

	@Override
	public Page<Enseignant> listEnseignant(Pageable page) {
		// TODO Auto-generated method stub
		return enseignantRepository.findAll(page);
	}

	@Override
	public Enseignant findByID(Long id) {
		// TODO Auto-generated method stub
		return enseignantRepository.findById(id).get();
	}

	@Override
	public Enseignant deleteEnseignant(Long id) {
		// TODO Auto-generated method stub
		Enseignant e = enseignantRepository.findById(id).get();
		enseignantRepository.delete(e);
		return e;
	}

	@Override
	public ResponseEntity<Enseignant> updateEnseignant(Long id, Enseignant e) {
		// TODO Auto-generated method stub
		Enseignant enseignant = enseignantRepository.findById(id).get();
		enseignant.setNom(e.getNom());
		enseignant.setPrenom(e.getPrenom());
		enseignant.setChargeHoraire(e.getChargeHoraire());
		enseignant.setDateEmbauche(e.getDateEmbauche());
		enseignant.setGrade(e.getGrade());
		enseignant.setNbHeureAbscence(e.getNbHeureAbscence());
		final Enseignant updatedEnseignant = enseignantRepository.save(enseignant);
		return ResponseEntity.ok(updatedEnseignant);
	}

	@Override
	public Page<Enseignant> findEnseignantByNom(String nom, Pageable page) {
		// TODO Auto-generated method stub
		return enseignantRepository.findByNomContains(nom, page);	
	}

	@Override
	public Page<Enseignant> findEnseignantByPrenom(String prenom, Pageable page) {
		// TODO Auto-generated method stub
		return enseignantRepository.findByPrenomContains(prenom, page);	
	}

	@Override
	public Page<Enseignant> findEnseignantByGrade(String grade, Pageable page) {
		// TODO Auto-generated method stub
		return enseignantRepository.findByGradeContains(grade, page);	
	}

	@Override
	public Page<Enseignant> findEnseignantByDateEmbauche(String begin, String end, Pageable page) throws ParseException {
		// TODO Auto-generated method stub
		Date dtBegin = new SimpleDateFormat("yyyy-MM-dd").parse(begin);
		Date dtEnd = new SimpleDateFormat("yyyy-MM-dd").parse(end);
		return enseignantRepository.findByDateEmbaucheBetween(dtBegin, dtEnd, page);
	}

	
	
}
