package com.aadi.testproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.aadi.testproject.DTO.Person;

@Service
@RequiredArgsConstructor
public class PersonService {


    void createPerson()
    {
        Person obj = Person.builder().name("Aadi").age(21).build();
        return;
    }
}
