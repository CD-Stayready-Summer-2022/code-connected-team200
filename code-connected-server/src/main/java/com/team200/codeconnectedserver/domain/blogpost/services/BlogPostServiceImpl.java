package com.team200.codeconnectedserver.domain.blogpost.services;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.blogpost.repo.BlogPostRepo;
import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import com.team200.codeconnectedserver.domain.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BlogPostServiceImpl implements BlogPostService {
    private final BlogPostRepo blogPostRepo;
    private ProfileService profileService;
    @Autowired
    public BlogPostServiceImpl(BlogPostRepo blogPostRepo, ProfileService profileService) {
        this.blogPostRepo = blogPostRepo;
        this.profileService = profileService;
    }



    public BlogPostServiceImpl(BlogPostRepo blogPostRepo) {
        this.blogPostRepo = blogPostRepo;
    }

    @Override
    public BlogPost create(BlogPost blogPost) {
        return blogPostRepo.save(blogPost);
    }

    @Override
    public BlogPost getById(Long id) {
        Optional<BlogPost>blogPost =blogPostRepo.findById(id);
    }

    @Override
    public List<BlogPost> getByProfile(Long id) {
        return null;
    }

    @Override
    public List<BlogPost> getByProfile(Profile profile) {
        return blogPostRepo.findByProfile(profile);
    }

    @Override
    public List<BlogPost> getByGroupName(String groupName) {
        return (List<BlogPost>) blogPostRepo.findByGroupName(groupName);
    }

    @Override
    public void likePost(Long id) {

    }


}
