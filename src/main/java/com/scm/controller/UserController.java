package com.scm.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.helpers.Helper;
import com.scm.services.UserService;




@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
   

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //user ka dashboard page 

    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }

     @RequestMapping(value = "profile", method=RequestMethod.GET)
     public String userProfile( Model model , org.springframework.security.core.Authentication authentication) {
       

      

         return "user/profile";
     }
     
    

    //User Ka add Contact 

    //


}
