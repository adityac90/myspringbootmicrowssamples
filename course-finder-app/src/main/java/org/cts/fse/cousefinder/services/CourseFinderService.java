package org.cts.fse.cousefinder.services;

import org.cts.fse.cousefinder.model.Course;

import java.util.List;

public interface CourseFinderService {

    List<Course> loadAllCourses();
}
