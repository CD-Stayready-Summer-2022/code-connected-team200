package com.team200.codeconnectedserver.domain.profile.model;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.education.model.Education;
import com.team200.codeconnectedserver.domain.employment.model.Job;
import lombok.*;
import org.springframework.boot.context.config.Profiles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NonNull
    List<Education> school;
    @NonNull
    List<Job> experience;
    @NonNull
    private String password;
    @NonNull
    private String email;
    @NonNull
    private String personalDescription;
    @NonNull
    private List<Profile> connections;
    @NonNull
    private List<Profiles>followers;
    @NonNull
    List<BlogPost> posts;


}