package com.aadi.School.service;

import com.aadi.School.model.School;
import com.aadi.School.repository.SchoolRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolService {

  private final SchoolRepository repository;

  public void saveSchool(School school) {
    repository.save(school);
  }

  public List<School> findAllSchools() {
    return repository.findAll();
  }
}
