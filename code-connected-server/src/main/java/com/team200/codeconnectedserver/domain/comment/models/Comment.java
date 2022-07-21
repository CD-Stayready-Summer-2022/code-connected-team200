package com.team200.codeconnectedserver.domain.comment.models;

import com.team200.codeconnectedserver.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.profile.model.Profile;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private Profile sender;
    @NonNull
    private String body;

    @NonNull
    @ManyToOne()
    private BlogPost blogPost;










}
