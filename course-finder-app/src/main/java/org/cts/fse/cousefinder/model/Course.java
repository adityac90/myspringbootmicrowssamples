package org.cts.fse.cousefinder.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "COURSES")
@Getter
@Setter
public class Course {

    public Course() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String courseName;
    private Integer proficiencyLevel;
    private String description;
    private String isLicenseNeeded;
    private String activityType;
    @ManyToOne
    @JoinColumn(name = "SKILL_ID")
    private Skill skill;
    @Temporal(TemporalType.DATE)
    @Column(name="CREATION_DATE")
    private Date courseCreationDate;
    @Column(name="STATUS")
    private String courseStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getCourseId(), course.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseId());
    }
}
