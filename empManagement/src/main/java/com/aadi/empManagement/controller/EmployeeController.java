package com.aadi.empManagement.controller;

import com.aadi.empManagement.model.Employee;
import com.aadi.empManagement.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @PostMapping
  public Employee saveEmployee(@RequestBody Employee emp) {
    return employeeService.saveEmployee(emp);
  }

  @GetMapping
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("/{id}")
  public Employee getEmployeeById(@PathVariable String id) {
    return employeeService.getEmployeeById(id);
  }

  @DeleteMapping("/{id}")
  public String deleteEmployeeById(@PathVariable String id) {
    return employeeService.deleteEmployeeById(id);
  }
}
