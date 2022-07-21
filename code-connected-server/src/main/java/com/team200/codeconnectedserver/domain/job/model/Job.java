package com.team200.codeconnectedserver.domain.job.model;


import com.team200.codeconnectedserver.domain.profile.model.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @NonNull
    private Profile poster;

    @NonNull
    private String company;

    @NonNull
    private String dateRange;

    @NonNull
    private String description;
}
