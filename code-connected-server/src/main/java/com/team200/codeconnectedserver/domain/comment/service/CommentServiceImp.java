package com.team200.codeconnectedserver.domain.comment.service;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.blogpost.services.BlogPostService;
import com.team200.codeconnectedserver.domain.comment.models.Comment;
import com.team200.codeconnectedserver.domain.comment.repo.CommentRepo;
import com.team200.codeconnectedserver.domain.core.exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImp implements CommentService {
    private CommentRepo commentRepo;
    private BlogPostService blogPostService;

    @Autowired
    public CommentServiceImp(CommentRepo commentRepo,BlogPostService blogPostService) {
        this.commentRepo = commentRepo;
        this.blogPostService = blogPostService;
    }

    @Override
    public Comment create(Comment comment) {
        Optional<Comment> commentOptional = commentRepo.findById(comment.getId());
        if(commentOptional.isPresent()) {
            throw new ResourceCreationException("Comment already exists");
        }
        return commentRepo.save(comment);
    }

    @Override
    public Comment getById(Long id) {
        Optional<Comment> commentOptional = commentRepo.findById(id);
        if (commentOptional.isEmpty()) {
            throw new ResourceNotFoundException("Comment with id " + id + " not found");
        }
        return commentOptional.get();
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Comment> commentOptional = commentRepo.findById(id);
        if (commentOptional.isEmpty()){
            throw new ResourceNotFoundException("Comment with id " + id + " not found");
        }
        commentRepo.delete(commentOptional.get());
        return true;
    }

    @Override
    public Comment like(Long id) throws ResourceNotFoundException {
        Optional<Comment> commentOptional = commentRepo.findById(id);
        if(commentOptional.isEmpty()) {
            throw new ResourceNotFoundException("Comment with id " + id + " not found");
        }
        Comment likedComment = commentOptional.get();
        Integer numOfLikes = likedComment.getLikes() + 1;
        likedComment.setLikes(numOfLikes);
        return commentRepo.save(likedComment);

    }

    @Override
    public List<Comment> getByBlogPost(Long id) throws ResourceNotFoundException {
        BlogPost blogPost = blogPostService.getById(id);
        List<Comment> comments = (List<Comment>) commentRepo.findByBlogPost(blogPost);
        return comments;
    }
}
