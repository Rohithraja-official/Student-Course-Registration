package com.rohithraja.studentreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rohithraja.studentreg.entity.Enrollment;
import java.util.Optional; // ADDED import

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // ADDED: Custom method to find an existing enrollment for a specific student and course
    Optional<Enrollment> findByStudentStudentIdAndCourseCourseId(Long studentId, Long courseId);
}