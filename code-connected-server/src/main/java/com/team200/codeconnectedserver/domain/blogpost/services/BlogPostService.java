package com.team200.codeconnectedserver.domain.blogpost.services;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.exceptions.ProfileNotFoundException;

import java.util.List;

public interface BlogPostService {
     BlogPost create (BlogPost blogPost);
     BlogPost getById(Long id);
     List<BlogPost> getByProfile(Long id) throws ProfileNotFoundException;
     List<BlogPost> getByGroupName(String groupName);
     BlogPost likePost(Long id, BlogPost blogPostDetail)throws ResourceNotFoundException;



}
