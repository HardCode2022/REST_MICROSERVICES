package com.formation.microservices.web.services.RestFullwebservice.user.jpa;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.formation.microservices.web.services.RestFullwebservice.user.AbsenceDeDonneesException;
import com.formation.microservices.web.services.RestFullwebservice.user.Post;
import com.formation.microservices.web.services.RestFullwebservice.user.User;

@RestController
public class UserJPARessources {
	
  @Autowired
  private UserJPARepository jpaUserRepository ;
  
  @Autowired
  private PostJPARepository jpaPostRepository ;
	
  @GetMapping("/jpa/users")	
  public List<User> findAllUser(){
	  
	return jpaUserRepository.findAll();  
  }  
    @GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
    	
		Optional<User> user = jpaUserRepository.findById(id);
		
		
		if(!user.isPresent()){
			
			throw new AbsenceDeDonneesException("id-"+ id);
		}
		
		EntityModel<User> resource = EntityModel.of(user.get());
		
		WebMvcLinkBuilder linkTo =linkTo(methodOn(this.getClass()).findAllUser());
		
		resource.add(linkTo.withRel("all-users"));
		
		//HATEOAS
		return resource;
	}
  
  @PostMapping("/jpa/users")	
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
	
	User userSaved = jpaUserRepository.save(user);  
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(userSaved.getId()).toUri();
	
	return ResponseEntity.created(location).build();
  }
  
  @DeleteMapping("/jpa/users/{id}")
  public void deleteUser(@PathVariable int id) {
	  
	  jpaUserRepository.deleteById(id);
	}
  
  //Methode permettant de recuper la liste des posts pour chaque User
  @GetMapping("/jpa/users/{id}/posts")	
  public List<Post> retrieveUserAllUsers(@PathVariable int id){
	  
	  Optional<User> userOptional = jpaUserRepository.findById(id); 
	  
	  if (!userOptional.isPresent()) {
		  throw new AbsenceDeDonneesException("id-"+ id);
	}
	return userOptional.get().getPosts();  
  } 
  @PostMapping("/jpa/users/{id}/posts")	
  public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post){
	
      Optional<User> userOptional = jpaUserRepository.findById(id); 
	  
	  if (!userOptional.isPresent()) {
		  throw new AbsenceDeDonneesException("id-"+ id);
	}
	  User user = userOptional.get();
	  post.setUser(user);
	  
	  jpaPostRepository.save(post);  
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(post.getId()).toUri();
	
	return ResponseEntity.created(location).build();
  }
  
  
}
