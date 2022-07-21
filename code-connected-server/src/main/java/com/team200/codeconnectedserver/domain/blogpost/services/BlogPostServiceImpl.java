package com.team200.codeconnectedserver.domain.blogpost.services;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.blogpost.repo.BlogPostRepo;
import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.profile.model.Profile;

import java.util.List;
import java.util.Optional;

public class BlogPostServiceImpl implements BlogPostService {
    private BlogPostRepo blogPostRepo;

    public BlogPostServiceImpl(BlogPostRepo blogPostRepo) {
        this.blogPostRepo = blogPostRepo;
    }

    @Override
    public BlogPost create(BlogPost blogPost) {
        return null;
    }

    @Override
    public Optional<BlogPost> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<BlogPost> getByProfile(Profile profile) {
        return null;
    }

    @Override
    public List<BlogPost> getByGroup(Group group) {
        return null;
    }
}
