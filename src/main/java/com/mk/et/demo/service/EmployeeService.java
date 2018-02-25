package com.mk.et.demo.service;

import com.mk.et.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);
}
