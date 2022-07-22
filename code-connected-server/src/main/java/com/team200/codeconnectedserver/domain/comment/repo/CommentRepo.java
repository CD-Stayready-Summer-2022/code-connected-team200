package com.team200.codeconnectedserver.domain.comment.repo;

import com.team200.codeconnectedserver.domain.comment.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {

}
