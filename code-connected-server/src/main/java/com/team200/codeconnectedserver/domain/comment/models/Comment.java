package com.team200.codeconnectedserver.domain.comment.models;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
@Entity
@Table(name = "comments")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && sender.equals(comment.sender) && body.equals(comment.body) && blogPost.equals(comment.blogPost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, body, blogPost);
    }
}
