package com.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.examen.entities.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {

}
