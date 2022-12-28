package com.formation.microservices.web.services.RestFullwebservice.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.microservices.web.services.RestFullwebservice.user.User;

@Repository
public interface UserJPARepository extends JpaRepository<User, Integer>{
}
