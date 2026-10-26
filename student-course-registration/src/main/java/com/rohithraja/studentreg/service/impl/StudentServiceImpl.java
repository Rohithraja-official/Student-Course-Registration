package com.rohithraja.studentreg.service.impl;

import com.rohithraja.studentreg.entity.Student;
import com.rohithraja.studentreg.exception.ResourceNotFoundException;
import com.rohithraja.studentreg.repository.StudentRepository;
import com.rohithraja.studentreg.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repo;

    @Override
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
}
