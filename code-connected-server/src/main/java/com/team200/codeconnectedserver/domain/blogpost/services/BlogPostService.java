package com.team200.codeconnectedserver.domain.blogpost.services;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.profile.model.Profile;

import java.util.List;
import java.util.Optional;

public interface BlogPostService {
     BlogPost create (BlogPost blogPost);
     Optional<BlogPost> getById(Long id);
     Optional<BlogPost> getByProfile(Long id);
     List<BlogPost> getByGroupName(String groupName);


}