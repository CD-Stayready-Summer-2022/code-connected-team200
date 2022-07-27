package com.team200.codeconnectedserver.domain.profile.service;


import com.team200.codeconnectedserver.domain.core.exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;

import com.team200.codeconnectedserver.domain.profile.model.Profile;


import java.util.List;
import java.util.Optional;


public interface ProfileService {
    Profile create(Profile profile) throws ResourceCreationException;
    Profile getById(Long id) throws ResourceNotFoundException;
    List<Profile> getAllFollowers(Long id) throws ResourceNotFoundException;
    List<Profile> getAllFollowing(Long id) throws ResourceNotFoundException;
    Optional<Profile> getByEmail(String email) throws ResourceNotFoundException;
    List<Profile> getByLastName(String LastName) throws ResourceNotFoundException;

    Profile update(Long id, Profile ProfileDetail) throws ResourceNotFoundException;

    void delete(Long id) throws ResourceNotFoundException;
}