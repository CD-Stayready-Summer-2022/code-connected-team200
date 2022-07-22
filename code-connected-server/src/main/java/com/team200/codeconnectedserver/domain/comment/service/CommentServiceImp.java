package com.team200.codeconnectedserver.domain.comment.service;

import com.team200.codeconnectedserver.domain.comment.models.Comment;
import com.team200.codeconnectedserver.domain.comment.repo.CommentRepo;
import com.team200.codeconnectedserver.domain.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImp implements CommentService {
    private CommentRepo commentRepo;

    @Autowired
    public CommentServiceImp(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }


    @Override
    public Comment create(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public Comment getById(Long id) {
        Optional<Comment> commentOptional = commentRepo.findById(id);
        if (commentOptional.isEmpty()) {

        }
        return commentOptional.get();
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Comment> commentOptional = commentRepo.findById(id);
        if (commentOptional.isEmpty()){

        }
        commentRepo.delete(commentOptional.get());
        return true;
    }
}
