package com.team200.codeconnectedserver.domain.group.services;

import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.group.repo.GroupRepo;
import com.team200.codeconnectedserver.domain.profile.model.Profile;

import java.util.List;
import java.util.Optional;

public class GroupServiceImpl implements GroupService{
    private GroupRepo groupRepo;

    public GroupServiceImpl(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    @Override
    public Group create(Group group) {
        return groupRepo.save(group);
    }

    @Override
    public Optional<Group> getById(Long id) {
        Optional<Group> group = groupRepo.findById(id);
        return group;
    }

    @Override
    public List<Profile> getMembers() {
        return groupRepo.findByProfile();
    }

    @Override
    public List<Profile> getAdmins() {
        return groupRepo.findByAdmin();
    }
}
