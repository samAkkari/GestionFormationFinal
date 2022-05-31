package com.esprit.examen.services;

import java.util.List;
import java.util.Optional;

import com.esprit.examen.entities.Session;

public interface ISessionService {
	
	Long addSession(Session session);

	Long modifierSession(Session session);

	void supprimerSession(Long sessionId);
	
	void affecterFormateurASession (Long formateurId, Long sessionId);
	
	List<Session> listSessions();



	Optional<Session> getById(long id);
	
	
}
