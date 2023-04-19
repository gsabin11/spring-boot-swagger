package com.swagger.service;

import java.util.List;

import com.swagger.model.Employee;

public interface EmployeeService {
	
	//to add employee
	public Employee addEmployee(Employee employee);
	
	//to fetch all employee
	
	public List<Employee> getAll();
	
	//to fetch single employee
	
	public Employee getSingleEmployee(long id);
	
	
	//to update employee
	
	public Employee updateEmployee(Employee empployee, long id);
	
	//to delete employee
	
	public void deleteEmployee(long id);

}
