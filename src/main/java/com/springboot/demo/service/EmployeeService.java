package com.springboot.demo.service;

import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id) throws ResourceNotFoundException;
    Employee updateEmployee(Employee employee, long id) throws ResourceNotFoundException;
    void deleteEmployee(long id) throws ResourceNotFoundException;
}
