package com.team200.codeconnectedserver.blogpost.blogpostrepo;

import com.team200.codeconnectedserver.blogpost.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepo extends JpaRepository<BlogPost,Long> {

}
