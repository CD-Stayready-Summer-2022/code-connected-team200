package com.team200.codeconnectedserver.domain.employment.repo;

import com.team200.codeconnectedserver.domain.employment.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface JobRepository extends JpaRepository<Job, Long> {
    Optional<Job> findByJobTitle(String jobTitle);
}
