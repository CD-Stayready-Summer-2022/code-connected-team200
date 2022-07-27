package com.team200.codeconnectedserver.domain.blogpost.repo;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepo extends JpaRepository<BlogPost,Long> {
    Iterable<BlogPost>findByGroupName(String groupName);
    Iterable<BlogPost>findByProfile(Profile profile);

}