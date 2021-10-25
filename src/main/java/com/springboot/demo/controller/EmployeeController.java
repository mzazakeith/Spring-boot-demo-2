package com.springboot.demo.controller;

import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.model.Employee;
import com.springboot.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
//    build create employee restAPI
//    we use response entity because we can give complete response body, header ....
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
//    build all get employees Rest API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

//    build get employee by id restapi
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) throws ResourceNotFoundException {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

//    build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee) throws ResourceNotFoundException {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,employeeId),HttpStatus.OK);
    }

//    build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId) throws ResourceNotFoundException {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }

}
