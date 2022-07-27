package com.team200.codeconnectedserver.domain.blogpost.services;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import com.team200.codeconnectedserver.exceptions.ProfileNotFoundException;

import java.util.List;
import java.util.Optional;

public interface BlogPostService {
     BlogPost create (BlogPost blogPost);
     BlogPost getById(Long id);
     List<BlogPost> getByProfile(Long id) throws ResourceNotFoundException;
    List<BlogPost>getByGroup(Long id)throws ResourceNotFoundException;
     BlogPost likePost(Long id, BlogPost blogPostDetail)throws ResourceNotFoundException;



}
