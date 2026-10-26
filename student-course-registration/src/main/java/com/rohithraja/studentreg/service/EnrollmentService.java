package com.rohithraja.studentreg.service;

import com.rohithraja.studentreg.dto.EnrollmentRequest;
import com.rohithraja.studentreg.entity.Enrollment;
import java.util.List; // Import missing list

public interface EnrollmentService {
    Enrollment enrollStudent(EnrollmentRequest request);
    List<Enrollment> getAllEnrollments(); // New method
}