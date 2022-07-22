package com.team200.codeconnectedserver.domain.profile.controller;

import com.team200.codeconnectedserver.domain.profile.model.Profile;
import com.team200.codeconnectedserver.exceptions.ProfileCreationException;
import com.team200.codeconnectedserver.exceptions.ProfileNotFoundException;
import com.team200.codeconnectedserver.domain.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/person")
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<Profile> create(@RequestBody Profile profile) throws ProfileCreationException {
        profile = profileService.create(profile);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Profile> getById(@PathVariable("id") Long id) throws ProfileNotFoundException {
        Profile profile  = profileService.getById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Profile> updated(@PathVariable("id") Long id, @RequestBody Profile personDetail) throws ProfileNotFoundException {
        Profile profile = profileService.update(id, personDetail);
        return new ResponseEntity<>(profile, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) throws ProfileNotFoundException {
        profileService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
