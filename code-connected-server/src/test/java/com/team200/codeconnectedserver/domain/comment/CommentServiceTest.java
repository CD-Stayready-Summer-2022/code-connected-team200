package com.team200.codeconnectedserver.domain.comment;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.blogpost.services.BlogPostService;
import com.team200.codeconnectedserver.domain.comment.models.Comment;
import com.team200.codeconnectedserver.domain.comment.repo.CommentRepo;
import com.team200.codeconnectedserver.domain.comment.service.CommentService;
import com.team200.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @MockBean
    private CommentRepo commentRepo;

    private Comment inputComment;

    private Comment testComment1;
    private Comment testComment2;
    private BlogPost blogPost;

    @BeforeEach
    public void setUp() {
        blogPost = new BlogPost();
        blogPost.setId(1l);
        inputComment = new Comment(new Profile(),"mock Comment",blogPost);
        testComment1 = new Comment(new Profile(),"test comment 01",blogPost);
        inputComment.setId(1l);
        testComment2 = new Comment(new Profile(),"Test comment 2",blogPost);
        testComment1.setId(2l);
        testComment2.setId(3l);
    }

    @Test
    @DisplayName("Create Test- Success")
    public void createTest() {
        BDDMockito.doReturn(inputComment).when(commentRepo).save(inputComment);
        Comment actualComment = commentService.create(inputComment);
        actualComment.setId(1l);
        Assertions.assertEquals(actualComment.getId(),inputComment.getId());
    }

    @Test
    @DisplayName("Create Test - Fail")
    public void createTest02() {

    }

    @Test
    @DisplayName("Get by Id - success")
    public void GetByIdTest01() {
        BDDMockito.doReturn(Optional.of(inputComment) ).when(commentRepo).findById(1l);
        Comment actualComment = commentService.getById(1l);
        Assertions.assertEquals(actualComment,inputComment);
    }

    @Test
    @DisplayName("Get by id - Fail")
    public void getByIdTest02(){
        BDDMockito.doReturn(Optional.empty()).when(commentRepo).findById(1l);
        Assertions.assertThrows(ResourceNotFoundException.class, () ->{
            commentService.getById(1l);
        });
    }

    @Test
    @DisplayName("Delete - Success")
    public void deleteTest01() {
        BDDMockito.doReturn(Optional.of(inputComment)).when(commentRepo).findById(1l);
        Assertions.assertTrue(commentService.delete(1l));
    }

    @Test
    @DisplayName("Delete- Fail")
    public void deleteTest02() {
        BDDMockito.doReturn(Optional.empty()).when(commentRepo).findById(1l);
        Assertions.assertThrows(ResourceNotFoundException.class,()->{
            commentService.delete(1l);
        });
    }

    @Test
    @DisplayName("Like - Success")
    public void likeTest01() {
        BDDMockito.doReturn(Optional.of(inputComment)).when(commentRepo).findById(1l);
        BDDMockito.doReturn(inputComment).when(commentRepo).save(ArgumentMatchers.any());
        commentService.like(1l);
        Integer expected = 1;
        Integer actual = inputComment.getLikes();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Like - Fail")
    public void likeTest02() {
        BDDMockito.doReturn(Optional.empty()).when(commentRepo).findById(1l);
        Assertions.assertThrows(ResourceNotFoundException.class,()->{
            commentService.like(1l);
        });
    }

   @Test
   @DisplayName("get by blog post - Success")
    public void getByBlogPostTest() {
       List<Comment> comments = new ArrayList<>();
       comments.add(testComment1);
       comments.add(testComment2);
       comments.add(inputComment);
       BDDMockito.doReturn(comments).when(commentRepo).findByBlogPost(blogPost);
       Iterable<Comment> actualComments = commentService.getByBlogPost(1l);
       Assertions.assertEquals(comments,actualComments);

   }


}
