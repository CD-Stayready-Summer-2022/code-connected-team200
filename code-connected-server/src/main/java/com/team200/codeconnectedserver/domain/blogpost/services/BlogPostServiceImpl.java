package com.team200.codeconnectedserver.domain.blogpost.services;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.blogpost.repo.BlogPostRepo;
import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.profile.model.Profile;

import java.util.List;
import java.util.Optional;

public class BlogPostServiceImpl implements BlogPostService {
    private final BlogPostRepo blogPostRepo;

    public BlogPostServiceImpl(BlogPostRepo blogPostRepo) {
        this.blogPostRepo = blogPostRepo;
    }

    @Override
    public BlogPost create(BlogPost blogPost) {
        return blogPostRepo.save(blogPost);
    }

    @Override
    public Optional<BlogPost> getById(Long id) {
        return blogPostRepo.findById(id);
    }
    @Override
    public Optional<BlogPost> getByProfile(Long id) {
        return blogPostRepo.findByProfile(id);
    }

    @Override
    public List<BlogPost> getByGroupName(String groupName) {
        return (List<BlogPost>) blogPostRepo.findByGroupName(groupName);
    }



}
