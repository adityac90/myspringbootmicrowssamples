package org.cts.fse.cousefinder.services.impl;

import org.cts.fse.cousefinder.model.Course;
import org.cts.fse.cousefinder.repository.CourseRepository;
import org.cts.fse.cousefinder.services.CourseFinderService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseFinderServiceImpl implements CourseFinderService {
    public static final String ACTIVE = "ACTIVE";
    private final CourseRepository courseRepository;

    public CourseFinderServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> loadAllCourses() {
        final List<Course> allCourses = courseRepository.findAll();
        final List<Course> sortedData = allCourses.stream().filter(course -> ACTIVE.equalsIgnoreCase(course.getCourseStatus())).sorted(Comparator.comparing(Course::getCourseCreationDate).reversed()).collect(Collectors.toList());
        return sortedData;
    }
}
