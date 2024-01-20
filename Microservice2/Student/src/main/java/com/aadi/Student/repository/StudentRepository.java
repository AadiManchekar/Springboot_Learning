package com.aadi.Student.repository;

import com.aadi.Student.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllBySchoolId(Integer schoolId);}
