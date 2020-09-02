package org.cts.fse.cousefinder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "SKILL")
public class Skill {
    public Skill() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long skillId;
    private String skillName;
    private String skillDescription;
    @OneToMany(mappedBy = "skill")
    @JsonIgnore
    private Set<Course> courses;

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        Skill skill = (Skill) o;
        return Objects.equals(getSkillId(), skill.getSkillId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSkillId());
    }
}
