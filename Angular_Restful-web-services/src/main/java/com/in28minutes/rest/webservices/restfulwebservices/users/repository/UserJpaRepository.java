package com.in28minutes.rest.webservices.restfulwebservices.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.restfulwebservices.users.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long>{

}














