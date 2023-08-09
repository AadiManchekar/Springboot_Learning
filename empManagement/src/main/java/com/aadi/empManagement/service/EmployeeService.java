package com.aadi.empManagement.service;

import com.aadi.empManagement.model.Employee;
import java.util.List;

public interface EmployeeService {
  Employee saveEmployee(Employee emp);

  List<Employee> getAllEmployees();

  Employee getEmployeeById(String id);

  String deleteEmployeeById(String id);
}
