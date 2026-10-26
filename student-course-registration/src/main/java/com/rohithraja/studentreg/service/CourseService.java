package com.rohithraja.studentreg.service;

import com.rohithraja.studentreg.entity.Course;
import java.util.List;

public interface CourseService {
    Course addCourse(Course course);
    Course getCourseById(Long id);
    List<Course> getAllCourses();
}
