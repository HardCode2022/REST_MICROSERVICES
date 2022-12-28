package com.formation.microservices.web.services.RestFullwebservice.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	
	@Autowired
	private RepositoryImpl repositoryImpl; 
	
	public List<User> findAllUsers(){
		return repositoryImpl.findAllUsers();		
	}
	
	public User saveUser(User user1){
		User user = repositoryImpl.saveUser(user1);		
		return user;	
	}
	
	public User findOneUser(int id) {
		User user =repositoryImpl.findOneUser(id);
		return user; 		
	}
		
	public User deleteById(int id) {		
	User user = repositoryImpl.deleteById(id);
	return user;
	}

}