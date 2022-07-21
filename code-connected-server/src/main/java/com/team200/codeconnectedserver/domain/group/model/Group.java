package com.team200.codeconnectedserver.domain.group.model;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String groupName;

    @NonNull
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "blogPosts")
    private List<BlogPost>blogPosts;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Profile owner;

    @NonNull
    @ManyToMany
    private List<Profile>admins;



}
