package com.team200.codeconnectedserver.domain.education.model;

import com.team200.codeconnectedserver.domain.profile.model.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String degree;
    private String schoolName;
    private String graduationDate;
    private Double gpa;

    @ManyToOne()
    private Profile profile;

    public Education(String degree, String schoolName, String graduationDate, Double gpa) {
        this.degree = degree;
        this.schoolName = schoolName;
        this.graduationDate = graduationDate;
        this.gpa = gpa;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return Objects.equals(id, education.id) && Objects.equals(degree, education.degree) && Objects.equals(schoolName, education.schoolName) && Objects.equals(graduationDate, education.graduationDate) && Objects.equals(gpa, education.gpa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, degree, schoolName, graduationDate, gpa);
    }
}
