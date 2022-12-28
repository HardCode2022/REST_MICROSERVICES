package com.formation.microservices.web.services.RestFullwebservice.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//@ApiModel(description="All details about the user.")
@Entity
public class User {
	@Id
	@GeneratedValue
	private int id ;
	@Size(min=2, message="Le nom doit avoir au minimum deux caractère")
	private String nom ;
	@Past
	private Date date_Naissance ;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	public User() {
		
	}

	public User(Integer id, String nom, Date dateNaissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.date_Naissance = dateNaissance;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Date getDateNaissance() {
		return date_Naissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.date_Naissance = dateNaissance;
	}


	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "utilisateur [id=" + id + ", nom=" + nom + ", date_Naissance=" + date_Naissance + "]";
	}
	
	

}
