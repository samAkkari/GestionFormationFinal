package com.esprit.examen.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.esprit.examen.entities.Cours;

public interface ICoursService {
	Long addCours(Cours cours);

	Long modifierCours(Cours cours);

	void supprimerCours(Long coursId);
	
	List<Cours> getCours();
	
	void affecterCoursASession(Long coursId, Long sessionId);
	
	Optional<Cours> findCoursById(Long id);
}
