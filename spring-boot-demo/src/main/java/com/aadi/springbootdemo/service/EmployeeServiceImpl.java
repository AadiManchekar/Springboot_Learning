package com.aadi.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.aadi.springbootdemo.exception.EmployeeNotFoundException;
import com.aadi.springbootdemo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {

        if (employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        Optional<Employee> emp = employees.stream().filter(c -> c.getEmployeeId().equals(id)).findFirst();

        if (emp.isPresent())
            return emp.get();

        throw new EmployeeNotFoundException("Employee not found with ID: " + id);
    }

    @Override
    public String deleteEmployeeById(String id) {

        Employee employee = employees.stream().filter(c -> c.getEmployeeId().equalsIgnoreCase(id)).findFirst().get();

        employees.remove(employee);

        return "Employee deleted with id: " + id;
    }

}
