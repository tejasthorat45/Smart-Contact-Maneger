package com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entities.User;



public interface UserRepo extends JpaRepository<User, String>{
    //extra method for db 
    //custom finding 


    Optional<User> findByEmail(String email);

}
