package com.rohithraja.studentreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rohithraja.studentreg.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}
