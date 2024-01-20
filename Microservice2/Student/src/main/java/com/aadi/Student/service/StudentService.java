package com.aadi.Student.service;

import com.aadi.Student.model.Student;
import com.aadi.Student.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository repository;

  public void saveStudent(Student student) {
    repository.save(student);
  }

  public List<Student> findAllStudents() {
    return repository.findAll();
  }
}
