package com.aadi.Student.controller;

import com.aadi.Student.model.Student;
import com.aadi.Student.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

  private final StudentService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody Student student) {
    service.saveStudent(student);
  }

  @GetMapping
  public ResponseEntity<List<Student>> findAllStudent() {
    return ResponseEntity.ok(service.findAllStudents());
  }

  @GetMapping("/school/{school-id}")
  public ResponseEntity<List<Student>> findAllStudentsBySchool(
    @PathVariable("school-id") Integer schoolId
  ) {
    return ResponseEntity.ok(service.findAllStudentsBySchool(schoolId));
  }
}
