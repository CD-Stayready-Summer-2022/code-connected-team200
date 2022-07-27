package com.team200.codeconnectedserver.domain.employment.services;

import com.team200.codeconnectedserver.domain.core.exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.core.exceptions.ResourceNotFoundException;
import com.team200.codeconnectedserver.domain.employment.model.Job;
import com.team200.codeconnectedserver.domain.employment.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    private JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public Job create(Job job) throws ResourceCreationException {
        Optional<Job> optional = jobRepository.findByJobTitle(job.getJobTitle());
        if (optional.isPresent())
            throw new ResourceCreationException("Held an position as: " + job.getJobTitle());
        job = jobRepository.save(job);
        return job;
    }

    @Override
    public Job getById(Long id) throws ResourceNotFoundException {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Job with id: " + id));
        return job;
    }

    @Override
    public Job getByJobTitle(String jobTitle) throws ResourceCreationException {
        Job job = jobRepository.findByJobTitle(jobTitle)
                .orElseThrow(() -> new ResourceNotFoundException("They have not held this position" + jobTitle));
        return job;
    }

    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job update(Long id, Job jobDetail) throws ResourceNotFoundException {
        Job job = getById(id);
        job.setJobTitle(jobDetail.getJobTitle());
        job.setCompanyName(jobDetail.getCompanyName());
        job.setJobDescription(jobDetail.getJobDescription());
        job.setDateRange(jobDetail.getDateRange());
        job = jobRepository.save(job);
        return job;
    }

    @Override
    public void delete(Long id) {
        Job job = getById(id);
        jobRepository.delete(job);
    }
}
