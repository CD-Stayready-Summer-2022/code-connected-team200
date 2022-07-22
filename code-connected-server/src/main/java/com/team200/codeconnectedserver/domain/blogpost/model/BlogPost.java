package com.team200.codeconnectedserver.domain.blogpost.model;

import com.team200.codeconnectedserver.domain.comment.models.Comment;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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
    private List<Comment> commentsList;
    @ManyToOne(cascade = CascadeType.ALL)
    private Profile profile;
    private Integer likes;





}
