package com.scm.scm20.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import java.util.ArrayList;

@Entity(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String userId;
    private String name;
    private String email;
    private String password;
    private String about;
    private String profilePic;
    private String phoneNumber;
    private String providerUserId;
    // info
    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

    //self,google,facebook,twitter,linkedin,github
    private Providers provider=Providers.SELF;
    private String providerUserfId;
    //add more if needed
            @OneToMany(mappedBy = "user", cascade= CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<contact> Contacts=new ArrayList<>();

            @OneToMany(mappedBy = "user", cascade= CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<SocialLink> links=new ArrayList<>();

}
