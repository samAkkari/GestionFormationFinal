package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Formateur implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	@Enumerated(EnumType.STRING)
	private Poste poste;
	@Enumerated(EnumType.STRING)
	private Contrat contrat;
	private String email;
	private String password;
	private Boolean admin;
	@OneToMany(mappedBy="formateur")
	private Set<Session> sessions;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Poste getPoste() {
		return poste;
	}
	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	
	
	
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Formateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", poste=" + poste + ", contrat="
				+ contrat + ", email=" + email + ", password=" + password + ", sessions=" + sessions + "]";
	}
	
	public Formateur(Long id, String nom, String prenom, Poste poste, Contrat contrat, String email, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.poste = poste;
		this.contrat = contrat;
		this.email = email;
		this.password = password;
	}
	public Formateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
