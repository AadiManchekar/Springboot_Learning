package com.aadi.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadi.springbootdemo.model.Employee;
import com.aadi.springbootdemo.service.EmployeeService;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeControllerv2 {

    @Qualifier("employeeServiceImplv2")
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}
