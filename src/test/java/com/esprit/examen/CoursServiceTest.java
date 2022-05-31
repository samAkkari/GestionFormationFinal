package com.esprit.examen;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.services.ICoursService;
import com.esprit.examen.services.ISessionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursServiceTest {

	private static final Logger l = LogManager.getLogger(CoursServiceTest.class);

	@Autowired
	ICoursService coursService;
	@Autowired
	ISessionService sessionService;

	@Test
	public void addCoursTest() {

		l.info("Debut addCours");
		Cours cours = new Cours();
		cours.setDescription("cours devops");
		cours.setIntitule("Devops");
		cours.setTypeCours(TypeCours.Informatique);

		Long id = coursService.addCours(cours);
		l.info("test addCours id N° : " + id);

		Assert.assertNotEquals(Optional.ofNullable(id), 0);
		Cours nvC = coursService.findCoursById(id).get();
		Assert.assertEquals(nvC.getTypeCours(), TypeCours.Informatique);
		Assert.assertEquals(nvC.getIntitule(), "Devops");
		coursService.supprimerCours(id);

		l.info("Fin addCours");
	}

	@Test
	public void UpdateCoursTest() {
		l.info("Debut UpdateCours");
		Cours cours = new Cours();
		cours.setDescription("cours devops");
		cours.setIntitule("Devops");
		cours.setTypeCours(TypeCours.Informatique);
		Long id = coursService.addCours(cours);

		cours.setId(id);
		cours.setTypeCours(TypeCours.Scrum);

		Long newId = coursService.modifierCours(cours);

		Assert.assertNotEquals(Optional.ofNullable(newId), 0);
		Assert.assertEquals(id, newId);

		Cours nvC = coursService.findCoursById(newId).get();
		l.info("test findCoursById id N: " + newId + " => " + nvC);
		l.info("Type cours :", nvC.getTypeCours());

		Assert.assertEquals(nvC.getTypeCours(), TypeCours.Scrum);
		Assert.assertEquals(nvC.getIntitule(), "Devops");

		coursService.supprimerCours(id);

		l.info("Fin UpdateCours");

	}

	@Test
	public void DeleteCoursTest() {
		l.info("Debut DeleteCours");
		Cours cours = new Cours();
		cours.setDescription("cours devops");
		cours.setIntitule("Devops");
		cours.setTypeCours(TypeCours.Informatique);
		Long id = coursService.addCours(cours);

		coursService.supprimerCours(id);

		Optional<Cours> op = coursService.findCoursById(id);
		if (op.isPresent())
			l.error("test erreur lors du suppression du cours id = " + id);
		Assert.assertFalse(op.isPresent());
		l.info("Fin DeleteCours");
	}


}