package com.team200.codeconnectedserver.services;

import com.team200.codeconnectedserver.domain.profile.model.Profile;
import com.team200.codeconnectedserver.domain.profile.repo.ProfileRepo;
import com.team200.codeconnectedserver.domain.profile.service.ProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

    @BeforeEach
    public void setUp01(){
        //mockProfile01 = new Profile(5L,"David","Adeleke")
        }
}
