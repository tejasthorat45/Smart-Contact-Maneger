package com.scm.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scm.repositories.UserRepo;

@Service
public class SecurityCutsomUserDeatailsService implements UserDetailsService{

    private UserRepo userRepo;
    

    public SecurityCutsomUserDeatailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       // apne user ko load karn a hai

        return userRepo.findByEmail(username)
       .orElseThrow(()-> new UsernameNotFoundException("User Not found with email : "+ username));




    }
    



}
