package com.scm.scm20.entities;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class contact {
    @Id
    private String id;
private String name;
    private String email;
    private String phoneNumber;
    private String picture;
    @Column(length=1000)
    private String description;
    private String address;
    private String websiteLink;
    private String linkedinLink;
    private boolean isFavorite=false;

    //private
    @ManyToOne
    private User user;
}
