package com.rohithraja.studentreg.service;

import com.rohithraja.studentreg.entity.Student;
import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
}
