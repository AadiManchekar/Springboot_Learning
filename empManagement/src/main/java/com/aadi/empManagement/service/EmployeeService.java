package com.aadi.empManagement.service;

import java.util.List;

import com.aadi.empManagement.model.Employee;

public interface EmployeeService {

    Employee saveEmployee(Employee emp);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);
    
}
