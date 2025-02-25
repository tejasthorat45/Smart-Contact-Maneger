package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.services.impl.SecurityCutsomUserDeatailsService;

@Configuration
public class SecurityConfig {

    //create A  user and login using javacode with in memories services
    
    // private UserDetails userDetails;

    // @Bean
    // public UserDetailsService userDetailsService(){

    //      UserDetails user = User
    //      .withDefaultPasswordEncoder()
    //      .username("admin123")
    //      .password("1234")
    //      .roles("ADMIN","USER")
    //      .build();

         

    //     var inMemoryUserDetailsManager =new InMemoryUserDetailsManager(user);

    //     return inMemoryUserDetailsManager;
    // }
    @Autowired
    private SecurityCutsomUserDeatailsService userDeatailsService;
    
    @Autowired
    private OAuthAuthenicationSuccessHandler handler;
    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        //UserDetails Service ka Object 

        daoAuthenticationProvider.setUserDetailsService(userDeatailsService);

        // ?/password encode kA OBJECT 
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        //configuration

        httpSecurity.csrf(csrf->csrf.disable());

        httpSecurity.authorizeHttpRequests(authrize->{
            authrize.requestMatchers("/user/**").authenticated();
            authrize.anyRequest().permitAll();
        });

        httpSecurity.formLogin(formLogin->{

            formLogin.loginPage("/login");
            formLogin.loginProcessingUrl("/authenticate");
            formLogin.successForwardUrl("/user/dashboard");
            //formLogin.failureForwardUrl("login?error=true");

            formLogin.usernameParameter("email");
            formLogin.passwordParameter("password");
            
        });
        httpSecurity.logout(logoutForm->{
            logoutForm.logoutUrl("/do-logout");
            logoutForm.logoutSuccessUrl("/login?logout=true");
        });

        httpSecurity.oauth2Login(oauth->{
            oauth.loginPage("/login");
            oauth.successHandler(handler);
        });

        



        return httpSecurity.build();



    }

    

}
