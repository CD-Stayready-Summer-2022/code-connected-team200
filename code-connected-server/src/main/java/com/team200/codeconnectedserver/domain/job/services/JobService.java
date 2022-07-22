package com.team200.codeconnectedserver.domain.job.services;

import com.team200.codeconnectedserver.domain.exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.job.model.Job;
import org.hibernate.engine.transaction.jta.platform.internal.JOnASJtaPlatform;

import java.util.List;

public interface JobService {
    Job create(Job job) throws ResourceCreationException;
    Job getById(Long id) throws ResourceNotFoundException;
    Job getByJobTitle(String jobTitle) throws ResourceNotFoundException;
    List<Job> getAll();
    Job update(Long id, Job jobDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
