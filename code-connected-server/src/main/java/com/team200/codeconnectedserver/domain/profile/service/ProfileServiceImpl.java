package com.team200.codeconnectedserver.domain.profile.service;

import com.team200.codeconnectedserver.domain.core.exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import com.team200.codeconnectedserver.domain.profile.repo.ProfileRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfileServiceImpl  implements ProfileService{

    private ProfileRepo profileRepo;

    @Autowired
    public ProfileServiceImpl(ProfileRepo profileRepo){
        this.profileRepo = profileRepo;
    }
    @Override
    public Profile create(Profile profile) throws ResourceCreationException {
        Optional<Profile> optional = profileRepo.findByEmail(profile.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("profile already exists " );
        return profileRepo.save(profile);
    }

    @Override
    public Profile getById(Long id) throws ResourceNotFoundException {
        Profile profile = profileRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("profile with id does not exists " + id));
        return profile;
    }

    @Override
    public List<Profile> getAllFollowers(Long id) throws ResourceNotFoundException {
        Profile profile = profileRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("profile with id does not exists " + id));
        return profile.getFollowers();
    }

    @Override
    public List<Profile> getAllFollowing(Long id) throws ResourceNotFoundException {
        Profile profile = profileRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("profile with id does not exists " + id));
        return profile.getFollowers();
    }

    @Override
    public Optional<Profile> getByEmail(String email) throws ResourceNotFoundException {
        Optional<Profile> optional = profileRepo.findByEmail(email);
        if (optional.isEmpty()) {
            throw new ResourceNotFoundException("profile with id does not exists " + email);
        }
        return optional;
    }

    @Override
    public List<Profile> getByLastName(String lastName) throws ResourceNotFoundException {
        List<Profile> profiles = (List) profileRepo.findByLastName(lastName);
        if(profiles.size() == 0)
            throw new ResourceNotFoundException("No users with last name " + lastName);
        return profiles;
    }

    @Override
    public Profile update(Long id, Profile profileDetail) throws ResourceNotFoundException {
        Profile savedProfile = getById(id);
        savedProfile.setFirstName(profileDetail.getFirstName());
        savedProfile.setLastName(profileDetail.getLastName());
        savedProfile.setEmail(profileDetail.getEmail());
        savedProfile.setPassword(profileDetail.getPassword());
        savedProfile.setSchool(profileDetail.getSchool());
        savedProfile.setExperience(profileDetail.getExperience());
        savedProfile.setPersonalDescription(profileDetail.getPersonalDescription());
        savedProfile.setFollowers(profileDetail.getFollowers());
        savedProfile.setFollowing(profileDetail.getFollowing());
        return profileRepo.save(savedProfile);
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Profile profile = getById(id);
        profileRepo.delete(profile);

    }
}