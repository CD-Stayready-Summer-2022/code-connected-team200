package com.team200.codeconnectedserver.domain.blogpost;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.blogpost.repo.BlogPostRepo;
import com.team200.codeconnectedserver.domain.blogpost.services.BlogPostService;
import com.team200.codeconnectedserver.domain.comment.models.Comment;
import com.team200.codeconnectedserver.domain.core.Exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.education.model.Education;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.job.model.Job;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import com.team200.codeconnectedserver.exceptions.ProfileNotFoundException;
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
public class BlogPostServiceTest {
    @Autowired
    BlogPostService blogPostService;
    @MockBean
    BlogPostRepo blogPostRepo;
    private BlogPost mockBlogPost;

    private BlogPost mockSavedBlogPost;

    private BlogPost mockSavedBlogPost2;

    private Comment mockComment;
    private Group mockGroup;
    private List<Comment> mockCommentList;
    private Profile mockProfile ;

    private Job mockJob;

    private Education mockEducation;

    private List<Profile>mockFollowerList;

    private List<Profile>mockFollowingList;
    private List<Profile>mockConnectionList;
    private List<Education>mockEducationList;
    private List<Job>mockExperience;

    private List<BlogPost>mockBlogPostList;


    @BeforeEach
    public void setUp(){
        mockFollowerList = new ArrayList<>();
        mockFollowingList = new ArrayList<>();
        mockConnectionList = new ArrayList<>();
        mockEducationList = new ArrayList<>();
        mockBlogPostList = new ArrayList<>();
        mockProfile = new Profile("firstName","lastName",mockEducationList,mockExperience,"email","password","description",mockConnectionList,mockFollowerList,mockFollowingList,mockBlogPostList);
        mockComment = new Comment();
        mockGroup = new Group();
        mockJob = new Job();
        mockEducation = new Education();
        mockCommentList.add(mockComment);
        mockBlogPost = new BlogPost("test",mockCommentList,mockProfile);
        mockSavedBlogPost = new BlogPost("test",mockCommentList,mockProfile);
        mockSavedBlogPost.setId(1L);
    }
    @Test
    @DisplayName("BlogPost service: create BlogPost - success")
    public void createBlogPostTestIsSuccess()throws ResourceCreationException {
        BDDMockito.doReturn(mockBlogPost).when(blogPostRepo).save(ArgumentMatchers.any());
        BlogPost returnedBlogPost=  blogPostService.create(mockSavedBlogPost);
        Assertions.assertNotNull(returnedBlogPost,"should not be null");
        Assertions.assertEquals(returnedBlogPost.getId(),1);

    }
    @Test
    @DisplayName("BlogPost Service : get by ID ")
    public void getBlogPostByIDTestSuccess()throws ResourceNotFoundException {
        BDDMockito.doReturn(Optional.of(mockBlogPost)).when(blogPostRepo).findById(1L);
        BlogPost foundBlogPost =  blogPostService.getById(1L);
        Assertions.assertEquals(mockBlogPost.toString(),foundBlogPost.toString());

    }

    @Test
    @DisplayName("BlogPost Service: Get By Id fail  ")
    public void getBlogPostByIdTestFail()throws ResourceNotFoundException{
        BDDMockito.doReturn(Optional.empty()).when(blogPostRepo).findById(1L);
        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            blogPostService.getById(1L);
        });

    }
    @Test
    @DisplayName("BlogPost Service: Get by profile")
    public void getBlogPostByProfileTest() throws ResourceNotFoundException, ProfileNotFoundException {
        List<BlogPost>blogPosts= new ArrayList<>();
        blogPosts.add(mockSavedBlogPost);
        blogPosts.add(mockSavedBlogPost2);
        BDDMockito.doReturn(mockBlogPost).when(blogPostRepo).findByProfile(mockProfile);
        List blogPostList = blogPostService.getByProfile(1L);
        Integer expected = 2;
        Integer actual = blogPostList.size();
        Assertions.assertEquals(expected,actual);


    }
    @Test
    @DisplayName("BlogPost Service: Get by profile ")
    public void getBlogPostByProfileTestFailed()throws ResourceNotFoundException{
        List<BlogPost>blogPosts = new ArrayList<>();
        BDDMockito.doReturn(blogPosts).when(blogPostRepo).findByProfile(mockProfile);
        Assertions.assertThrows(ResourceNotFoundException.class, ()->{
            List<BlogPost>blogPostList = blogPostService.getByProfile(1l);
        });

    }

}
