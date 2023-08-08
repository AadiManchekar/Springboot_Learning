package com.aadi.empManagement.service;

import com.aadi.empManagement.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  List<Employee> employees = new ArrayList<>();

  @Override
  public Employee saveEmployee(Employee emp) {
    if (emp.getEmployeeId() == null || emp.getEmailId().isEmpty()) {
      emp.setEmployeeId(UUID.randomUUID().toString());
    }
    employees.add(emp);
    return emp;
  }
}
