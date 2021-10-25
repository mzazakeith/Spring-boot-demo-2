package com.springboot.demo.service.impl;

import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.model.Employee;
import com.springboot.demo.repository.EmployeeRepository;
import com.springboot.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//no need to add transaction annotation spring data jpa will provide transaction to all its methods
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

//    if a class is configured as a spring bean, has only one constructor the @autowired can be omitted and spring will use it automatically and inject all necessary dependencies
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
//        check whether employee with given id is existing database or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee", "Id",id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {

//        check whether employee exists or not
        employeeRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee", "Id",id));
        employeeRepository.deleteById(id);

    }

}
