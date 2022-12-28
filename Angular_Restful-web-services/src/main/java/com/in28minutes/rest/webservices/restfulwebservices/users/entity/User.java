package com.in28minutes.rest.webservices.restfulwebservices.users.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id ;
    private String nom;
    private Long age ;
    private String poste;
	private String competences;
	private String note ;
	private String image ;
	
	public User() {
		
	}

	public User(Long id, String nom, Long age, String poste, String competences, String note, String image) {
		super();
		this.id = id;
		this.nom = nom;
		this.age = age;
		this.poste = poste;
		this.competences = competences;
		this.note = note;
		this.image = image;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getCompetences() {
		return competences;
	}

	public void setCompetences(String competences) {
		this.competences = competences;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", age=" + age + ", poste=" + poste + ", competences=" + competences
				+ ", note=" + note + ", image=" + image + "]";
	}

}
