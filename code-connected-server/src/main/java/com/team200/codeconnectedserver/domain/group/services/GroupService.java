package com.team200.codeconnectedserver.domain.group.services;

import com.team200.codeconnectedserver.domain.exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.profile.model.Profile;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    Group create(Group group)throws ResourceCreationException;
    Group getById(Long id)throws ResourceNotFoundException;
    List<Profile> getMembers() ;
    List<Profile>getAdmins();
    Group addMember(Long id, Profile profile);

    void delete(Long id)throws ResourceNotFoundException;

}
