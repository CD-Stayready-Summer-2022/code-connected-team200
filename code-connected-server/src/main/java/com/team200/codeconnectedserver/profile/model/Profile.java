package com.team200.codeconnectedserver.profile.model;

import com.team200.codeconnectedserver.blogpost.model.BlogPost;
import lombok.*;

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    @NonNull
    List<Education> school;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "experience")
    @NonNull
    List<Job> experience;
    @NonNull
    private String personalDescription;
    @NonNull
    private List<Profile> connections;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    @NonNull
    List<BlogPost> posts;


}
