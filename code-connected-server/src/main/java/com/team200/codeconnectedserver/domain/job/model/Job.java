package com.team200.codeconnectedserver.domain.job.model;

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
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String jobTitle;

    @NonNull
    private String companyName;

    @NonNull
    private String dateRange;

    @NonNull
    private String jobDescription;

    public String toString(){
        return String.format("%d %s %s %s %s", id, jobTitle, companyName,dateRange,jobDescription);
    }
}
