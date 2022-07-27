package com.team200.codeconnectedserver.domain.profile.service;

import com.team200.codeconnectedserver.domain.core.Exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import com.team200.codeconnectedserver.exceptions.ProfileCreationException;
import com.team200.codeconnectedserver.exceptions.ProfileNotFoundException;

import java.util.List;
import java.util.Optional;


public interface ProfileService {
    Profile create(Profile profile) throws ResourceCreationException;
    Profile getById(Long id) throws ResourceNotFoundException;
    List<Profile> getAllFollowers(Long id) throws ResourceNotFoundException;
    List<Profile> getAllFollowing(Long id) throws ResourceNotFoundException;
    Optional<Profile> getByEmail(String email) throws ResourceNotFoundException;
    List<Profile> getByLastName(String LastName) throws ResourceNotFoundException;
    Profile update(Long id, Profile ProfileDetail) throws ResourceNotFoundException, ProfileNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}