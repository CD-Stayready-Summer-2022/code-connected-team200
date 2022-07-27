package com.team200.codeconnectedserver.domain.education.model;

import com.team200.codeconnectedserver.domain.profile.model.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @NonNull
    private String degree;

    @NonNull
    private String school;

    @NonNull
    private String graduationDate;

    @NonNull
    private String description;
    @ManyToOne
    @NonNull
    private Profile profile;

    public String toString(){
        return String.format("%d %s %s %s %s", id, degree,school,graduationDate,description);
    }

}
