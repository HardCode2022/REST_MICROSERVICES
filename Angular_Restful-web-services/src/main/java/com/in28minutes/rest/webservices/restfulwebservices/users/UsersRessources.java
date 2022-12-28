package com.in28minutes.rest.webservices.restfulwebservices.users;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.exception.PasUtiliseateurException;
import com.in28minutes.rest.webservices.restfulwebservices.users.entity.User;
import com.in28minutes.rest.webservices.restfulwebservices.users.repository.UserJpaRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UsersRessources {

	//MDP:dummy
	@Autowired
	private UserJpaRepository userJpaRepository;
	
    //Recuperer la liste complete des utilisateurs 
	@GetMapping("/jpa/utilisateurs")
	public List<User>recupererListes(){	
		return userJpaRepository.findAll();	
	}
	
	//Recuperer un utilisateur par Id
	@GetMapping("jpa/utilisateurs/{id}")	
	public User recuperUserparId(@PathVariable Long id) throws PasUtiliseateurException{
				
//			if (Objects.nonNull(id) && id >=7) {
//					throw new PasUtiliseateurException("Aucun utilisateur defini pour ce ididentifiant");			
//			}
			
			return userJpaRepository.findById(id).get()	;
	}
	//Creation d'un Utilisateur 
	@PostMapping("/jpa/utilisateurs/creation")
	public ResponseEntity<Void> creationUtilisateur(@RequestBody User user){
		
		User createdUser = userJpaRepository.save(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdUser.getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	//Supprimer un Utilisateur
	@DeleteMapping("/jpa/utilisateurs/supprimer/{id}")
	public ResponseEntity<Void> supprimerUtilisateur(@PathVariable Long id){
		userJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();                     
	}
	         
	//Mettre à jour Utilisateur
	@PutMapping("/jpa/utilisateurs/mettreAJour/{id}")
	public ResponseEntity<User> misAjourUtilisateur(@PathVariable Long id, @RequestBody User user){
		
	  User utilisateurMisAJour = userJpaRepository.save(user);
		
	  return new ResponseEntity<User>(utilisateurMisAJour, HttpStatus.OK);
	}
	
}

