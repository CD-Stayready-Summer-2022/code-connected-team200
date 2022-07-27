package com.team200.codeconnectedserver.services;

import com.team200.codeconnectedserver.domain.blogpost.model.BlogPost;
import com.team200.codeconnectedserver.domain.education.model.Education;
import com.team200.codeconnectedserver.domain.exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.job.model.Job;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import com.team200.codeconnectedserver.domain.profile.repo.ProfileRepo;
import com.team200.codeconnectedserver.domain.profile.service.ProfileService;
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
public class ProfileServiceTest {

    @Autowired
    private ProfileService profileService;

    @MockBean
    private ProfileRepo profileRepo;
    private Profile mockProfile01;
    private Profile savedProfile01;
    private Profile savedProfile02;
    private List<Profile> mockConnectionList;
    private List<Education> mockEducationList;
    private List<Job> mockExperience;
    private List<Profile> mockfollowers;
    private List<Profile> mockfollowing;
    List<BlogPost> mockposts;

    @BeforeEach
    public void setUp01() {
        mockConnectionList = new ArrayList<>();
        mockfollowers = new ArrayList<>();
        mockfollowing = new ArrayList<>();
        mockposts = new ArrayList<>();

        Profile mockProfile01 = new Profile("firstName", "lastName", mockEducationList, mockExperience, "email", "password", "description", mockposts);
        Profile savedProfile01 = new Profile("firstName", "lastName", mockEducationList, mockExperience, "email", "password", "description", mockposts);
        savedProfile01.setId(1L);

        Profile savedProfile02 = new Profile("firstName2", "lastName", mockEducationList, mockExperience, "email2", "password2", "description2", mockposts);
    }

    @Test
    @DisplayName("Create Profile - Success")
    public void createProfileTest01() throws ResourceCreationException {
        BDDMockito.doReturn(Optional.empty()).when(profileRepo).findById(ArgumentMatchers.any());
        BDDMockito.doReturn(savedProfile01).when(profileRepo).save(mockProfile01);
        Profile profile = profileService.create(mockProfile01);
        Assertions.assertNotNull(profile.getId());
    }

    @Test
    @DisplayName("Create Profile - fail")
    public void createProfileTest02() throws ResourceCreationException {
        BDDMockito.doReturn(Optional.of(savedProfile01)).when(profileRepo).findById(ArgumentMatchers.any());
        BDDMockito.doReturn(savedProfile01).when(profileRepo).save(mockProfile01);
        Assertions.assertThrows(ResourceCreationException.class, () -> {
            profileService.create(mockProfile01);
        });
    }

    @Test
    @DisplayName("Get By Id")
    public void getPersonByIdTest01() {
        BDDMockito.doReturn(Optional.of(savedProfile01)).when(profileRepo).findById(1l);
        Profile profile = profileService.getById(1l);
        Assertions.assertNotNull(profile);
    }

    @Test
    @DisplayName("Get By Last name - success")
    public void getByLastNameTest01() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(savedProfile01);
        profiles.add(savedProfile02);
        BDDMockito.doReturn(profiles).when(profileRepo).findByLastName("lastName");
        List<Profile> actualPeople = profileService.getByLastName("lastName");
        Integer expected = 2;
        Integer actual = actualPeople.size();
        Assertions.assertEquals(expected, actual);
    }
}
