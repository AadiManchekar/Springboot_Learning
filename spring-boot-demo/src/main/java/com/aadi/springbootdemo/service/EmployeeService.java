package com.aadi.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import com.aadi.springbootdemo.model.Employee;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(String id);
}
