package com.team200.codeconnectedserver.domain.education.service;

import antlr.collections.List;
import com.team200.codeconnectedserver.domain.education.model.Education;
import com.team200.codeconnectedserver.domain.exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;

public interface EducationService {
    Education create(Education job) throws ResourceCreationException;
    Education getById(Long id) throws ResourceNotFoundException;

    Education getBySchool(String school) throws ResourceNotFoundException;

    Education getByDegree(String degree) throws ResourceNotFoundException;
    List<Education> getAll();
    Education update(Long id, Education educationDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
