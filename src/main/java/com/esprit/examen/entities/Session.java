package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Session implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private Long duree;
	private String description;
	@ManyToOne
    Formateur formateur;
	@ManyToMany
	Set<Cours> cours;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Long getDuree() {
		return duree;
	}
	public void setDuree(Long duree) {
		this.duree = duree;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public Set<Cours> getCours() {
		return cours;
	}
	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", duree=" + duree
				+ ", description=" + description + "]";
	}
	public Session(Long id, Date dateDebut, Date dateFin, Long duree, String description) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.description = description;
	}
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
