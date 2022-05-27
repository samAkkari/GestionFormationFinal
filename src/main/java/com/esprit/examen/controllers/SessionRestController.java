package com.esprit.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.examen.entities.Session;
import com.esprit.examen.services.ISessionService;

@RestController
public class SessionRestController {

	@Autowired
	ISessionService sessionService;
	
	@PostMapping("/ajouterSession")
	@ResponseBody
	public Session ajouterSession(@RequestBody Session session) {
		sessionService.addSession(session);
		return session;
	}

	@PutMapping("/modifierSession")
	@ResponseBody
	public Session modifierSession(@RequestBody Session session) {
		sessionService.addSession(session);
		return session;
	}
	
	@PutMapping("/affecterFormateurASession/{formateurId}/{sessionId}")
	@ResponseBody
	public String affecterFormateurASession(@PathVariable("formateurId")  Long formateurId, @PathVariable("sessionId") Long sessionId) {
		sessionService.affecterFormateurASession(formateurId, sessionId);
		return "formateur affecté correctement";
	}

	@DeleteMapping("/supprimerSession/{sessionId}")
	@ResponseBody
	public void supprimerSession(@PathVariable("sessionId") Long sessionId) {
		sessionService.supprimerSession(sessionId);
	}
}
