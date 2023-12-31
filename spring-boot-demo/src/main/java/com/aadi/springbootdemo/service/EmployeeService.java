package com.aadi.springbootdemo.service;

import java.util.List;

import com.aadi.springbootdemo.model.Employee;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
