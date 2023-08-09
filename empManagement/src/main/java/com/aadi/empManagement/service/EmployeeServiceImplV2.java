package com.aadi.empManagement.service;

import com.aadi.empManagement.entity.EmployeeEntity;
import com.aadi.empManagement.error.EmployeeNotFoundException;
import com.aadi.empManagement.model.Employee;
import com.aadi.empManagement.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplV2 implements EmployeeService {

  @Autowired
  EmployeeRepository employeeRepository;

  @Override
  public Employee saveEmployee(Employee emp) {
    if (emp.getEmployeeId() == null || emp.getEmailId().isEmpty()) {
      emp.setEmployeeId(UUID.randomUUID().toString());
    }

    EmployeeEntity entity = new EmployeeEntity();
    BeanUtils.copyProperties(emp, entity);
    employeeRepository.save(entity);

    return emp;
  }

  @Override
  public List<Employee> getAllEmployees() {
    List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
    List<Employee> employees = employeeEntityList
      .stream()
      .map(e -> {
        Employee employee = new Employee();
        BeanUtils.copyProperties(e, employee);
        return employee;
      })
      .collect(Collectors.toList());
    return employees;
  }

  @Override
  public Employee getEmployeeById(String id) {
    Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(
      id
    );

    if (employeeEntityOptional.isEmpty()) {
      throw new EmployeeNotFoundException("Employee Not found with ID " + id);
    }

    EmployeeEntity employeeEntity = employeeEntityOptional.get();
    Employee emp = new Employee();
    BeanUtils.copyProperties(employeeEntity, emp);
    return emp;
  }

  @Override
  public String deleteEmployeeById(String id) {
    employeeRepository.deleteById(id);
    return "Employee deleted with ID passed " + id;
  }
}
