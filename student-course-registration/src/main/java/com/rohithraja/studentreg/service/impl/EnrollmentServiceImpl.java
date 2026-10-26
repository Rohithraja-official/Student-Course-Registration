package com.rohithraja.studentreg.service.impl;

import com.rohithraja.studentreg.dto.EnrollmentRequest;
import com.rohithraja.studentreg.entity.Course;
import com.rohithraja.studentreg.entity.Enrollment;
import com.rohithraja.studentreg.entity.Student;
import com.rohithraja.studentreg.exception.ResourceNotFoundException;
import com.rohithraja.studentreg.repository.CourseRepository;
import com.rohithraja.studentreg.repository.EnrollmentRepository;
import com.rohithraja.studentreg.repository.StudentRepository;
import com.rohithraja.studentreg.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional; // ADDED import

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private EnrollmentRepository enrollmentRepo;

    @Override
    public Enrollment enrollStudent(EnrollmentRequest request) {

        // 1. Fetch Student and Course
        Student student = studentRepo.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Course course = courseRepo.findById(request.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
  
        // 2. CHECK FOR DUPLICATE ENROLLMENT (ADDED LOGIC)
        Optional<Enrollment> existingEnrollment = enrollmentRepo.findByStudentStudentIdAndCourseCourseId(
                request.getStudentId(),
                request.getCourseId()
        );

        if (existingEnrollment.isPresent()) {
            throw new RuntimeException("Student is already enrolled in this course.");
        }

        // 3. Create and Save new Enrollment
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.now());
           
        return enrollmentRepo.save(enrollment);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }
}