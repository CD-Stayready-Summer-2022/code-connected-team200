package com.team200.codeconnectedserver.domain.profile.service;

import com.team200.codeconnectedserver.domain.profile.model.Profile;
import com.team200.codeconnectedserver.exceptions.ProfileCreationException;
import com.team200.codeconnectedserver.exceptions.ProfileNotFoundException;
import lombok.NonNull;
import org.springframework.boot.context.config.Profiles;

import java.util.List;
import java.util.Optional;

public class ProfileServiceImpl  implements ProfileService{


    @Override
    public Profile create(Profile profile) throws ProfileCreationException {
        return null;
    }

    @Override
    public Profile getById(Long id) throws ProfileNotFoundException {
        return null;
    }

    @Override
    public @NonNull List<Profiles> getAllFollowers(Long id) throws ProfileNotFoundException {
        return null;
    }

    @Override
    public @NonNull List<Profiles> getAllFollowing(Long id) throws ProfileNotFoundException {
        return null;
    }

    @Override
    public Optional<Profile> getByEmail(String email) throws ProfileNotFoundException {
        return Optional.empty();
    }

    @Override
    public List<Profile> getByLastName(String LastName) throws ProfileNotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) throws ProfileNotFoundException {

    }

    @Override
    public Profile update(Long id, Profile ProfileDetail) throws ProfileNotFoundException {
        return null;
    }
}