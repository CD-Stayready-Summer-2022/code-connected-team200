package com.team200.codeconnectedserver.domain.blogpost.repo;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogPostRepo extends JpaRepository<BlogPost,Long> {
    Optional<BlogPost>findByProfile(Long id);
    Iterable<BlogPost>findByGroupName(String groupName);




}