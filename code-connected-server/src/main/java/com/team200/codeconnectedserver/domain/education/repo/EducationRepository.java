package com.team200.codeconnectedserver.domain.education.repo;

import com.team200.codeconnectedserver.domain.education.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EducationRepository extends JpaRepository<Education, Long> {
    Optional<Education> findByDegree(String degree);
    Optional<Education> findBySchool(String school);

}
