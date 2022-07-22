package com.team200.codeconnectedserver.domain.profile.service;

import com.team200.codeconnectedserver.domain.profile.model.Profile;
import com.team200.codeconnectedserver.exceptions.ProfileCreationException;
import com.team200.codeconnectedserver.exceptions.ProfileNotFoundException;

import java.util.List;
import java.util.Optional;


public interface ProfileService {
    Profile create(Profile profile) throws ProfileCreationException;
    Profile getById(Long id) throws ProfileNotFoundException;
    List<Profile> getAllFollowers(Long id) throws ProfileNotFoundException;
    List<Profile> getAllFollowing(Long id) throws ProfileNotFoundException;
    Optional<Profile> getByEmail(String email) throws ProfileNotFoundException;
    List<Profile> getByLastName(String LastName) throws ProfileNotFoundException;
    Profile update(Long id, Profile ProfileDetail) throws ProfileNotFoundException;
    void delete(Long id) throws ProfileNotFoundException;
}
