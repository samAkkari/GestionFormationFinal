package com.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;


@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long>{

	
//	@Query("toDo....")
	//public Long nombreFormateursImpliquesDansUnCours(@Param("typeCours")TypeCours typeCours);
	

}
