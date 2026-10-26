package com.rohithraja.studentreg.controller;

import com.rohithraja.studentreg.entity.Student;
import com.rohithraja.studentreg.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }
}
