package com.team200.codeconnectedserver.profile.model;

import lombok.*;

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
    private String personalDescription;
    @NonNull
    private List<Profile> connections;
    @NonNull
    List<BlogPost> posts;


}
