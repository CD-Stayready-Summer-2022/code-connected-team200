package com.team200.codeconnectedserver.domain.employment.services;


import com.team200.codeconnectedserver.domain.core.exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.employment.model.Job;

import java.util.List;

public interface JobService {
    Job create(Job job) throws ResourceCreationException;
    Job getById(Long id) throws ResourceNotFoundException;
    Job getByJobTitle(String jobTitle) throws ResourceNotFoundException;
    List<Job> getAll();
    Job update(Long id, Job jobDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
