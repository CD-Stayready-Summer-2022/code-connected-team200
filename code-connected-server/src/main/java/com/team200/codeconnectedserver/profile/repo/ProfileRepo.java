package com.team200.codeconnectedserver.profile.repo;

import com.team200.codeconnectedserver.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepo extends JpaRepository <Profile,Long> {
    @Override
    Optional<Profile> findById(Long Id);
    Optional <Profile> findByEmail(String email);
    Iterable<Profile> findByLastName(String lastName);
    Optional<Profile> findByPost(String blogPost);

}
