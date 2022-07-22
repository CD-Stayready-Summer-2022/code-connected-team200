package com.team200.codeconnectedserver.domain.comment.service;

import com.team200.codeconnectedserver.domain.comment.models.Comment;

public interface CommentService {
    Comment create(Comment comment);

    Comment getById(Long id);

    Boolean delete(Long id);
}
