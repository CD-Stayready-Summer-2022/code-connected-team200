package com.team200.codeconnectedserver.domain.group.services;

import com.team200.codeconnectedserver.domain.blogpost.services.BlogPostService;
import com.team200.codeconnectedserver.domain.core.Exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.group.repo.GroupRepo;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import com.team200.codeconnectedserver.domain.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

public class GroupServiceImpl implements GroupService{
    private BlogPostService blogPostService;
    private ProfileService profileService;
    private GroupRepo groupRepo;
    @Autowired
    public GroupServiceImpl(BlogPostService blogPostService, GroupRepo groupRepo, ProfileService profileService) {
        this.blogPostService = blogPostService;
        this.groupRepo = groupRepo;
        this.profileService= profileService;
    }
    @Override
    public Group create(Group group) throws ResourceCreationException {
        return groupRepo.save(group);
    }
    @Override
    public Group getById(Long id) throws ResourceNotFoundException {
        Optional<Group>optional = groupRepo.findById();
        if(optional.isEmpty()){
            throw new ResourceNotFoundException("that group does not exist");
        }
        return optional.get();
    }

    @Override
    public List<Profile> getMembers()  {
        return groupRepo.findAllMembers();
    }
    @Override
    public List<Profile> getAdmins()  {
        return groupRepo.findAllAdmins();
    }
    @Override
    public Group addMember(Long id, Profile profile) {
        Group savedGroup = getById(id);
        savedGroup.getMembers().add(profile);
        return groupRepo.save(savedGroup);
    }



    @Override
    public void delete(Long id)throws ResourceNotFoundException{
        Group group = getById(id);
        groupRepo.delete(group);

    }

}
