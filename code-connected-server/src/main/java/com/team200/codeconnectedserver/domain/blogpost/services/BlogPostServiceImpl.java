package com.team200.codeconnectedserver.domain.blogpost.services;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.blogpost.repo.BlogPostRepo;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;

import com.team200.codeconnectedserver.domain.profile.service.ProfileService;
import com.team200.codeconnectedserver.exceptions.ProfileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BlogPostServiceImpl implements BlogPostService {
    private final BlogPostRepo blogPostRepo;
    private static Logger logger = LoggerFactory.getLogger(BlogPostServiceImpl.class);
    private ProfileService profileService;
    @Autowired
    public BlogPostServiceImpl(BlogPostRepo blogPostRepo, ProfileService profileService) {
        this.blogPostRepo = blogPostRepo;
        this.profileService = profileService;
    }


    @Override
    public BlogPost create(BlogPost blogPost)  {
        return(blogPostRepo.save(blogPost));
    }

    @Override
    public BlogPost getById(Long id) throws ResourceNotFoundException {
        Optional<BlogPost>blogPostOptional =blogPostRepo.findById(id);
        if(blogPostOptional.isEmpty()){
            logger.error("blogpost with id{} does not exist",id);
            throw new ResourceNotFoundException("blog post not found");

        }
        return blogPostOptional.get();
    }

    @Override
    public List<BlogPost> getByProfile(Long Profile_id) throws ResourceNotFoundException, ProfileNotFoundException {
        List<BlogPost>blogPosts = (List)blogPostRepo.findByProfile(profileService.getById(Profile_id));
        if(blogPosts.size()==0){
            logger.error("blogposts with that id are not found ");
            throw new ResourceNotFoundException("blogpost with that id are not found");
        }
        return blogPosts;
    }

    @Override
    public List<BlogPost> getByGroupName(String groupName) throws ResourceNotFoundException {
        List<BlogPost>blogPosts = (List<BlogPost>) blogPostRepo.findByGroupName(groupName);
        if(blogPosts.size()==0){
            throw new ResourceNotFoundException("no blog posts are associated with that group name");
        }
        return blogPosts;
    }



    @Override
    public BlogPost likePost(Long id, BlogPost blogPostDetail) throws ResourceNotFoundException {
        BlogPost savedBlogPost = getById(id);
        int currentNumberOfLikes =blogPostDetail.getLikes();
        savedBlogPost.setLikes(currentNumberOfLikes+1);
       return  blogPostRepo.save(savedBlogPost);


    }
}
