package com.formation.microservices.web.services.RestFullwebservice.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

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

@RestController
public class UserRessources {
	
  @Autowired
  private UserDaoService service ;
	
  @GetMapping("/users")	
  public List<User> findAllUser(){
	return service.findAllUsers();  
  }
  
//  @GetMapping("users/{id}")
//  public User rechecherUser(@PathVariable int id){
//	  
//	  User user =  service.findOneUser(id);	  
//	  if (user ==null) {
//		throw new AbsenceDeDonneesException("id-"+ id);
//	}
//	  return user; 
//  }
  
    @GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = service.findOneUser(id);
		
		if(user==null){
			
			throw new AbsenceDeDonneesException("id-"+ id);
		}
		
		EntityModel<User> resource = EntityModel.of(user);
		
		WebMvcLinkBuilder linkTo =linkTo(methodOn(this.getClass()).findAllUser());
		
		resource.add(linkTo.withRel("all-users"));
		
		//HATEOAS
		return resource;
	}
	//  @PostMapping("/users")	
	//  public void createUser(@RequestBody User user){
	//	User userSaved = service.saveUser(user);  
	//  }
  
  @PostMapping("/users")	
  public ResponseEntity<Object> findAllUser(@Valid @RequestBody User user){
	
	User userSaved = service.saveUser(user);  
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(userSaved.getId()).toUri();
	
	return ResponseEntity.created(location).build();
  }
  
  @DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user==null){
			throw new AbsenceDeDonneesException("id-"+ id);		
			
		}
	}
  
}
