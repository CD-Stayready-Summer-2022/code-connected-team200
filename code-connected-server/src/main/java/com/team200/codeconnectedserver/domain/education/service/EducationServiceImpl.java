package com.team200.codeconnectedserver.domain.education.service;

import com.team200.codeconnectedserver.domain.education.model.Education;
import com.team200.codeconnectedserver.domain.education.repo.EducationRepository;
import com.team200.codeconnectedserver.domain.exceptions.ResourceCreationException;
import com.team200.codeconnectedserver.domain.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationService{
    private EducationRepository educationRepository;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository){
        this.educationRepository = educationRepository;
    }

    @Override
    public Education create(Education education) throws ResourceCreationException{
        Optional<Education> optional = educationRepository.findByDegree(education.getDegree());
        if (optional.isPresent())
            throw new ResourceCreationException("User has an " + education.getDegree() + " degree");
        education = educationRepository.save(education);
        return education;
    }

    @Override
    public Education getById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Education getBySchool(String school) throws ResourceNotFoundException{
        Education education = educationRepository.findBySchool(school)
                .orElseThrow(()->new ResourceNotFoundException("User has no school " + school));
        return education;
    }
    @Override
    public Education getByDegree(String degree) throws ResourceNotFoundException {
        Education education = educationRepository.findByDegree(degree)
                .orElseThrow(() -> new ResourceNotFoundException("No degreee was found " + degree));
        return education;
    }

    @Override
    public List<Education> getAll() {
        return educationRepository.findAll();
    }

    @Override
    public Education update(Long id, Education educationDetail) throws  ResourceNotFoundException{
        Education education = getById(id);
        education.setDegree(educationDetail.getDegree());
        education.setSchool(educationDetail.getSchool());
        education.setGraduationDate(educationDetail.getGraduationDate());
        education.setDescription(educationDetail.getDescription());
        education = educationRepository.save(education);
        return education;
    }

    @Override
    public void delete(Long id){
        Education education = getById(id);
        educationRepository.delete(education);
    }



}
