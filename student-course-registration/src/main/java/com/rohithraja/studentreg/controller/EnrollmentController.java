package com.rohithraja.studentreg.controller;

import com.rohithraja.studentreg.dto.EnrollmentRequest;
import com.rohithraja.studentreg.entity.Enrollment;
import com.rohithraja.studentreg.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Import missing list

@RestController
@RequestMapping("/api/enroll")
public class EnrollmentController {

    @Autowired
    private EnrollmentService service;

    @PostMapping
    public Enrollment enroll(@RequestBody EnrollmentRequest request) {
        return service.enrollStudent(request);
    }

    @GetMapping("/enrollments") // New GET mapping
    public List<Enrollment> getAll() {
        return service.getAllEnrollments();
    }
}