package com.rohithraja.studentreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rohithraja.studentreg.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {}
