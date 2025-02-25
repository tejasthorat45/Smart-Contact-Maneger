package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MesssageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class PageController {
    
    @Autowired
    private UserService userservice;
    
    @GetMapping("/")
    public String index(){
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "tejas thorat");
        model.addAttribute("youtubeChannel", "Learn With Durgesh");

        return "home";
    }

    // about

    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("about page loading");

        return "about";
    }
    

    //services
    @RequestMapping("/services")
    public String services() {
        System.out.println("srvies  page loading");

        return "services";
    }

    @GetMapping("/contact")
    public String contactPage() {
        System.out.println("contactpage loading");

        return "contact";
    }

    // login

    @GetMapping("/login")
    public String login() {
        
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        //default data bhi dddal skte hail
        model.addAttribute("userForm", userForm);
        
        return "register";
    }

    // processing register 
   
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister( @Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult,HttpSession session){


        // fetch the form data 

        System.out.println(userForm);
        //validate form data

        if(rBindingResult.hasErrors()){
            return "register";

        }



        //userservice
       // userform ----> user mai convert karke User mai save kare db mai save
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhonenumber(userForm.getPhoneNumber());
        user.setProfilepic("https://www.dreamstime.com/sophisticated-low-light-male-avatar-perfect-use-as-default-profile-picture-social-media-forums-dating-sites-image353712307");


        
        
        User saveduser = userservice.saveUser(user);

        System.out.println("User Saved ");


        //message -> registration succesful

        //add the message 

        Message message= Message.builder().content("Registration Succesfull").type(MesssageType.blue).build();
        session.setAttribute("message",message);


        //redirect to login page


        return "redirect:/register";

    }
    
    

}
