package com.mk.et.demo.service;

import com.mk.et.demo.model.Employee;
import com.mk.et.demo.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    public void getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "Mike", "Newell", "mn@test.com", "123456789","Worker",true));
        employees.add(new Employee(2L, "Mike", "Newell", "mn@test.com", "123456789","Worker",true));
        employees.add(new Employee(3L, "Mike", "Newell", "mn@test.com", "123456789","Worker",true));
        when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> employeeList = employeeService.getAllEmployees();
        assertEquals(3, employeeList.size());
    }

    @Test
    public void getEmployeeById() {
        Employee employee = new Employee(1L, "Mike", "Newell", "mn@test.com", "123456789","Worker",true);
        when(employeeRepository.findOne(anyLong())).thenReturn(employee);
        Employee employeeById = employeeService.getEmployeeById(1L);
        assertEquals(employee.getId(), employeeById.getId());
        assertEquals(employee.getName(), employeeById.getName());
        assertEquals(employee.getLastName(), employeeById.getLastName());
        assertEquals(employee.getEmail(), employeeById.getEmail());
        assertEquals(employee.getPhone(), employeeById.getPhone());
        assertEquals(employee.getPosition(), employeeById.getPosition());
        assertEquals(employee.isActive(), employeeById.isActive());

    }
}