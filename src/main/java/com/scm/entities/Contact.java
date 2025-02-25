package com.scm.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Contact {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;

    @Column(columnDefinition = "TEXT")
    private String description;
    private boolean favorite = false;

    //private List<SocialLink> socialLinks = new ArrayList<>();

    private String websiteLink;
    private String LinkedInLink;
    //many conatct have a single user



    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SocialLink> links = new ArrayList<>();
}
