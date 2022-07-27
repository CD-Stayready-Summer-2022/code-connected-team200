package com.team200.codeconnectedserver.domain.education.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
