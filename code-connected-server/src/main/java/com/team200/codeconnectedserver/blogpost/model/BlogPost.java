package com.team200.codeconnectedserver.blogpost.model;

import com.team200.codeconnectedserver.profile.model.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blogPost")
    private List<Comments>commentsList;
    @ManyToOne(cascade = CascadeType.ALL)
    private Profile profile;
    private Integer likes;





}
