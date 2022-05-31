package com.esprit.examen;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.esprit.examen.entities.Session;
import com.esprit.examen.services.IFormateurService;
import com.esprit.examen.services.ISessionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceSession {
	
	private static final Logger l = LogManager.getLogger(CoursServiceTest.class);

	
    @Autowired
    public ISessionService sessionService;
    @Autowired
    IFormateurService formateurService;
    @Test
    public void addSession() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut = dateFormat.parse("2022-03-22");
        Date dateFin = dateFormat.parse("2022-03-23");
        Session sesion = new Session(null, dateDebut,dateFin, 2l,"c'est une session pour le cours springboot");
        assertThat(sesion.getDescription()).isNotNull();
        sessionService.addSession(sesion);
    }
    @Test
    public void addSessionTest() {
    l.info("Commencer addSession test");
            Session newSession = new Session(2l,null, null, null, "description");
            Long id = sessionService.addSession(newSession);
            l.info("test ajout session id : " + id);
            Assert.assertNotEquals(Optional.ofNullable(id), 0);
    }

    @Test
        public void UpdateSessionTest() {
    l.info("Commencer updateSession test");
    Session newSession = new Session(2l,null, null, null, "description");
            Long id = sessionService.addSession(newSession);
            newSession.setDescription("new description");
            Long newId = sessionService.modifierSession(newSession);
            Assert.assertNotEquals(Optional.ofNullable(newId), 0);
            Assert.assertEquals(id,newId);
        }

    @Test
        public void DeleteSessionTest() {
    l.info("Commencer deleteSession test");
    Session newSession = new Session(2l,  "description");
            Long  id = sessionService.addSession(newSession);
            sessionService.supprimerSession(id);
            Optional<Session> op = sessionService.getById(id);
            if (op.isPresent())
                l.error("test echec du suppression id = "+ id);
            Assert.assertFalse(op.isPresent());

        }}


