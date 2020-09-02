package org.cts.fse.cousefinder.controller;

import org.cts.fse.cousefinder.model.Course;
import org.cts.fse.cousefinder.services.CourseFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    private final CourseFinderService courseFinderService;

    public CourseController(CourseFinderService courseFinderService) {
        this.courseFinderService = courseFinderService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseFinderService.loadAllCourses());

    }

}
