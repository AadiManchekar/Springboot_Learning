package com.aadi.School.service;

import com.aadi.School.client.StudentClient;
import com.aadi.School.model.FullSchoolResponse;
import com.aadi.School.model.School;
import com.aadi.School.repository.SchoolRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolService {

  private final StudentClient studentClient;

  private final SchoolRepository repository;

  public void saveSchool(School school) {
    repository.save(school);
  }

  public List<School> findAllSchools() {
    return repository.findAll();
  }

  public FullSchoolResponse findAllSchoolStudents(Integer schoolId) {
    School school =
        repository.findById(schoolId).orElse(School.builder().name("NOT_FOUND").build());
    var students = studentClient.findAllStudentsBySchool(schoolId);

    return FullSchoolResponse.builder()
        .name(school.getName())
        .email(school.getEmail())
        .students(students)
        .build();
  }
}
