package com.springboot.demo.repository;

import com.springboot.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//no need to add repository annotation jpa will take care of it
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
