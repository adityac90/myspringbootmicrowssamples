package org.cts.fse.cousefinder.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;



public enum ProficiencyLevel {
    GURU(5), EXPERT(4), PROFESSIONAL(3), INTERMEDIATE(2), PRACTIONER(1);

    ProficiencyLevel(int level) {
        this.level = level;
    }

    private int level;

    public int getLevel() {
        return level;
    }
}
