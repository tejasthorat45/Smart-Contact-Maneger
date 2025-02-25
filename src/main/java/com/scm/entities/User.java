package com.scm.entities;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity(name = "user")
@Table(name = "users")
public class User implements UserDetails {

    @Id //primary key
    private String UserId;
    
    @Column(name = "user_name" ,nullable = false)
    private String name;

    private String email;
    @Getter(value = AccessLevel.NONE)
    private String password;

    @Column(columnDefinition = "TEXT")
    private String about;

    @Column(columnDefinition = "TEXT")
    private String profilepic;

    private String phonenumber;

    //verfication
    @Getter(value = AccessLevel.NONE)
    private boolean enabled = false;
    private boolean emailVerfied = false;
    private boolean phoneVerfied = false;

    // socia login facebbook ,twitter, google

     @Enumerated(value = EnumType.STRING)
    // SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB
    private Providers provider = Providers.SELF;
    private String providerUserId;


    //mapping single user having many contacts
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Contact> contacts = new ArrayList<>();
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> RoleList = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<SimpleGrantedAuthority> roles = RoleList.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
       
        return roles;
    }


    @Override
    public String getUsername() {
        
        return this.email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
       return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    

    


}
