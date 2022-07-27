package com.team200.codeconnectedserver.domain.education.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
<<<<<<< HEAD
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
=======
>>>>>>> f5ff1d7638a7b63d1caeb098d8779b2450d9f9d0
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Education {

    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
    @NonNull
>>>>>>> f5ff1d7638a7b63d1caeb098d8779b2450d9f9d0
    private Long id;

    @NonNull
    private String degree;

    @NonNull
    private String school;

    @NonNull
    private String graduationDate;

    @NonNull
    private String description;

    public String toString(){
        return String.format("%d %s %s %s %s", id, degree,school,graduationDate,description);
    }

}
