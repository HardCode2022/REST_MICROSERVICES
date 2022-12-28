package com.formation.microservices.web.services.RestFullwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RepositoryImpl {
	
	private static List<User> users = new ArrayList<>();
	private static int count = 3;
	
	static{
		
		users.add(new User(1,"GUILAVOGUI", new Date()));
		users.add(new User(2,"KAMANO", new Date()));
		users.add(new User(3,"CONDE", new Date()));
		users.add(new User(4,"TENGUIANO", new Date()));
		users.add(new User(5,"CAMARA", new Date()));

	}
	
	public List<User> findAllUsers(){
		return users;
		
	}
	
	public User saveUser(User user){
		
		if (user.getId()==null) {
			user.setId(++count);			
		}
		users.add(user);
		return user;	
	}
	
	public User findOneUser(int id) {
		for (User user : users) {
			if (user.getId()==id) {
				
				return user; 
			}
		}
		return null;
	}
		
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
