package com.team200.codeconnectedserver.domain.blogpost.controller;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.blogpost.services.BlogPostService;
import com.team200.codeconnectedserver.domain.group.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping()
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
        Optional<BlogPost> blogPost = blogPostService.getById(id);
        return new ResponseEntity<>(blogPost,HttpStatus.OK);
    }

}
