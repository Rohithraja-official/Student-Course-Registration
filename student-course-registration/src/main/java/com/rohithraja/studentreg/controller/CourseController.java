package com.rohithraja.studentreg.controller;

import com.rohithraja.studentreg.entity.Course;
import com.rohithraja.studentreg.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public Course create(@RequestBody Course course) {
        return service.addCourse(course);
    }

    @GetMapping
    public List<Course> getAll() {
        return service.getAllCourses();
    }
}
