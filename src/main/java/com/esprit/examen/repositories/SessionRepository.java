package com.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long>{

}
