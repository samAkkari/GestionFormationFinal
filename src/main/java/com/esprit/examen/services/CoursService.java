package com.esprit.examen.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;

@Service
public class CoursService implements ICoursService {

	@Autowired
	CoursRepository coursRepository;
	@Autowired
	SessionRepository sessionRepository;

	@Override
	public Long addCours(Cours cours) {
		// logger
		coursRepository.save(cours);
		return cours.getId();
	}

	@Override
	public Long modifierCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
	}

	@Override
	public void supprimerCours(Long coursId) {
		coursRepository.deleteById(coursId);

	}

	@Override
	public List<Cours> getCours() {

		List<Cours> cours = coursRepository.findAll();
		return cours;
	}

	@Override
	public void affecterCoursASession(Long coursId, Long sessionId) {
		Cours c = coursRepository.findById(coursId).get();
		Set<Session> sessions = c.getSessions();
		Session s = sessionRepository.findById(sessionId).get();
		Set<Cours> cours = s.getCours();
		sessions.add(s);
		cours.add(c);
		c.setSessions(sessions);
		s.setCours(cours);
		coursRepository.save(c);

	}

	@Override
	public Optional<Cours> findCoursById(Long id) {
		return coursRepository.findById(id);
	}

}
