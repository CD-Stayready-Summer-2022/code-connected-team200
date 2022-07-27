package com.team200.codeconnectedserver.domain.blogpost.controller;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.blogpost.services.BlogPostService;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.group.model.Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/BlogPost")
public class BlogPostController {
    private BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @PostMapping
    public ResponseEntity<BlogPost>create(@RequestBody BlogPost blogPost){
        blogPost = blogPostService.create(blogPost);
        return new ResponseEntity<>(blogPost, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Optional<BlogPost>> getById(@PathVariable("id")Long id){
        Optional<BlogPost> blogPost = Optional.ofNullable(blogPostService.getById(id));
        return new ResponseEntity<>(blogPost,HttpStatus.OK);
    }
    @GetMapping("by- profile")
    public ResponseEntity<List<BlogPost>>getBlogPostByProfile(@PathVariable Long id) throws ResourceNotFoundException {
        List<BlogPost> blogPost = blogPostService.getByProfile(id);
        return new ResponseEntity<>(blogPost,HttpStatus.OK);
    }
    @GetMapping("by - group")
    public ResponseEntity<List<BlogPost>>getBlogPostByGroupName(@PathVariable Group groupName){
        List<BlogPost>blogPosts = blogPostService.getByGroup(groupName);
        return new ResponseEntity<>(blogPosts,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<BlogPost>likePost(@PathVariable("id")Long id, @RequestBody BlogPost blogPostDetail){
        BlogPost blogPost = blogPostService.likePost(id, blogPostDetail);
        return new ResponseEntity<>(blogPost,HttpStatus.ACCEPTED);

    }


}
