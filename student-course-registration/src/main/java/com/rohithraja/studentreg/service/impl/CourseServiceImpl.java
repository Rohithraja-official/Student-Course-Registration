package com.rohithraja.studentreg.service.impl;

import com.rohithraja.studentreg.entity.Course;
import com.rohithraja.studentreg.exception.ResourceNotFoundException;
import com.rohithraja.studentreg.repository.CourseRepository;
import com.rohithraja.studentreg.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repo;

    @Override
    public Course addCourse(Course course) {
        return repo.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    @Override
    public List<Course> getAllCourses() {
        return repo.findAll();
    }
}
