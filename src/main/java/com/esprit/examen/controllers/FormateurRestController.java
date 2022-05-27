package com.esprit.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.services.IFormateurService;

@RestController
public class FormateurRestController {

	@Autowired
	IFormateurService formateurService;
	
	@PostMapping("/ajouterFormateur")
	@ResponseBody
	public Formateur ajouterFormateur(@RequestBody Formateur formateur) {
		formateurService.addFormateur(formateur);
		return formateur;
	}

	@PutMapping("/modifierFormateur")
	@ResponseBody
	public Formateur modifierFormateur(@RequestBody Formateur formateur) {
		formateurService.addFormateur(formateur);
		return formateur;
	}

	@DeleteMapping("/supprimerFormateur/{formateurId}")
	@ResponseBody
	public void supprimerFormateur(@PathVariable("formateurId") Long formateurId) {
		formateurService.supprimerFormateur(formateurId);
	}
	
	@GetMapping("/nombreFormateursImpliquesDansUnCours/{typeCours}")
	@ResponseBody
	public Long nombreFormateursImpliquesDansUnCours(@PathVariable("typeCours") TypeCours typeCours) {
		Long nombreFormateurs=formateurService.nombreFormateursImpliquesDansUnCours(typeCours);
		return nombreFormateurs;
	}
}
