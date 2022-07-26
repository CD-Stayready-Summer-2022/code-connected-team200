package com.team200.codeconnectedserver.domain.blogpost.model;

import com.team200.codeconnectedserver.domain.comment.models.Comment;

import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import lombok.*;


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

    @NonNull
    private String body;

    @NonNull
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blogPost")
    private List<Comment> commentsList;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Profile profile;

    private Integer likes = 0;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
