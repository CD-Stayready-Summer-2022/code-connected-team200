package com.team200.codeconnectedserver.domain.blogpost.blogpostrepo;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepo extends JpaRepository<BlogPost,Long> {

}
