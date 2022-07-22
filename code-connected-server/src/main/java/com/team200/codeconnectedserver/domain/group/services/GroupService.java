package com.team200.codeconnectedserver.domain.group.services;

import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.profile.model.Profile;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    Group create(Group group);
    Optional<Group> getById(Long id);
    List<Profile> getMembers();
    List<Profile>getAdmins();
}
