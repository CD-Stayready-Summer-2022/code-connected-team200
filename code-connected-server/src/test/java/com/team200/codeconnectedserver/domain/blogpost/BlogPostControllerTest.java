package com.team200.codeconnectedserver.domain.blogpost;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.blogpost.services.BlogPostService;
import com.team200.codeconnectedserver.domain.comment.models.Comment;
import com.team200.codeconnectedserver.domain.education.model.Education;
import com.team200.codeconnectedserver.domain.exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.job.model.Job;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import com.team200.codeconnectedserver.domain.profile.service.ProfileService;
import lombok.NonNull;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.print.attribute.standard.Media;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class BlogPostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlogPostService blogPostService;
    @MockBean
    private ProfileService profileService;
    private Comment mockComment;
    private Group mockGroup;
    private List<Comment> mockCommentList;
    private Profile mockProfile ;
    private BlogPost mockBlogPost;
    private BlogPost mockSaveBlogPost;

    private Job mockJob;

    private Education mockEducation;

    private List<Profile>mockFollowerList;

    private List<Profile>mockFollowingList;
    private List<Education>mockEducationList;
    private List<BlogPost>mockBlogPostList;
    private List<Job>mockJoblist;
    private String profileDescription;
    List<Profile> mockConnectionList;



    @BeforeEach
    public void setUp(){

        mockProfile = new Profile("firstName","lastName",mockEducationList,mockJoblist,"email","password","description",mockConnectionList,mockFollowerList,mockFollowingList,mockBlogPostList);
        mockComment = new Comment();
        mockGroup = new Group();
        mockJob = new Job();
        mockEducation = new Education();
        mockCommentList.add(mockComment);
        mockBlogPost = new BlogPost("test",mockCommentList,mockProfile);
        mockSaveBlogPost = new BlogPost("test",mockCommentList,mockProfile);
        mockSaveBlogPost.setId(1L);
    }
    @Test
    @DisplayName("BlogPost Create - /api/v1/blogPost: success")
    public void createBlogPostRequestSuccesss()throws Exception {
        BDDMockito.doReturn(mockSaveBlogPost).when(blogPostService).create(mockBlogPost);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/blogPost")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonConverter.asJsonString(mockBlogPost)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));

    }
    @Test
    @DisplayName("BlogPost Create - /api/v1/blogPost : failed ")
    public void createBlogPostRequestFailed()throws Exception{
        BDDMockito.doThrow(new ResourceCreationException("Exists")).when(blogPostService).create(mockBlogPost);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/blogPost")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonConverter.asJsonString(mockBlogPost)))
                .andExpect(MockMvcResultMatchers.status().isConflict());

    }
    @Test
    @DisplayName("BlogPost get by Id /api/v1/blogPost/{id} : success ")
    public void getByIdSuccess()throws Exception{
        BDDMockito.doReturn(mockSaveBlogPost).when(blogPostService).getById(1l);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/blogPost/{id}",1))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id",Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body",Is.is("test")));
    }
    @Test
    @DisplayName("Get by Id /api/v1/blogPost{id} : fail")
    public void getByIdFail()throws Exception{
        BDDMockito.doThrow(new ResourceNotFoundException("not found")).when(blogPostService).getById(1l);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/blogPost/{id}",1))
                .andExpect(MockMvcResultMatchers.status().isNotFound());


    }



}
