package com.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swagger.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
