package com.team200.codeconnectedserver.domain.education.repo;

import com.team200.codeconnectedserver.domain.education.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepo extends JpaRepository<Education,Long> {
}
