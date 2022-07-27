package com.team200.codeconnectedserver.domain.comment;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.comment.models.Comment;
import com.team200.codeconnectedserver.domain.comment.repo.CommentRepo;
import com.team200.codeconnectedserver.domain.comment.service.CommentService;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

    @BeforeEach
    public void setUp() {
        inputComment = new Comment(new Profile(),"mock Comment",new BlogPost());
        testComment1 = new Comment(new Profile(),"test comment 01",new BlogPost());
        inputComment.setId(1l);
        testComment2 = new Comment(new Profile(),"Test comment 2",new BlogPost());
        testComment1.setId(2l);
        testComment2.setId(3l);
    }

    @Test
    @DisplayName("Create Test- Success")
    public void createTest() {
        BDDMockito.doReturn(testComment1).when(commentRepo).save(inputComment);
        Comment actualComment = commentService.create(testComment1);
        Assertions.assertEquals(actualComment,testComment1);
    }

    @Test
    @DisplayName("Create Test - Fail")
    public void createTest02() {

    }

    @Test
    @DisplayName("Get by Id - success")
    public void GetByIdTest01() {
        BDDMockito.doReturn(inputComment).when(commentRepo).findById(1l);
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


}
