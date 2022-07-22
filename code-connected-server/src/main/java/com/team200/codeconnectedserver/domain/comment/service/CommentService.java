package com.team200.codeconnectedserver.domain.comment.service;

import com.team200.codeconnectedserver.domain.comment.models.Comment;
import com.team200.codeconnectedserver.domain.exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;

public interface CommentService {
    Comment create(Comment comment) throws ResourceCreationException;

    Comment getById(Long id) throws ResourceNotFoundException;

    Boolean delete(Long id) throws ResourceNotFoundException;

    Comment like(Long id) throws ResourceNotFoundException;

    Iterable<Comment> getByBlogPost(Long id) throws ResourceNotFoundException;
}
