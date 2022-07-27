package com.team200.codeconnectedserver.domain.profile.model;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.education.model.Education;
import com.team200.codeconnectedserver.domain.employment.model.Job;
import lombok.*;
import org.springframework.boot.context.config.Profiles;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blogPost")
    @NonNull
    List<Education> school;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Profile")
    @NonNull
    List<Job> experience;
    @NonNull
    private String password;
    @NonNull
    private String email;
    @NonNull
    private String personalDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Profile")
    @NonNull
    private List<Profile> connections;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Profile")
    @NonNull
    private List<Profile>followers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Profile")
    @NonNull
    private List<Profile>following;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Profile")
    @NonNull
    List<BlogPost> posts;


}