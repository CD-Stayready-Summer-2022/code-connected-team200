package com.team200.codeconnectedserver.domain.comment.controller;

import com.team200.codeconnectedserver.domain.comment.models.Comment;
import com.team200.codeconnectedserver.domain.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment createdComment = commentService.create(comment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Comment> likeComment(@PathVariable("id") Long id) {
        Comment comment = commentService.like(id);
        return new ResponseEntity<>(comment,HttpStatus.ACCEPTED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<Comment>> viewAllCommentsOnPost(@RequestParam Long id) {
        Iterable<Comment> comments = commentService.getByBlogPost(id);
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getById(id);
        return new ResponseEntity<>(comment,HttpStatus.OK);
    }


}
