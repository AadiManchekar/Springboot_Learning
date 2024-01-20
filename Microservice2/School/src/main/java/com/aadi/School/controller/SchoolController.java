package com.aadi.School.controller;

import com.aadi.School.model.School;
import com.aadi.School.service.SchoolService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schools")
public class SchoolController {

  private final SchoolService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody School school) {
    service.saveSchool(school);
  }

  @GetMapping
  public ResponseEntity<List<School>> findAllSchool() {
    return ResponseEntity.ok(service.findAllSchools());
  }
}
