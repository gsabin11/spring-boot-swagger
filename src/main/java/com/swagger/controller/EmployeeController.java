package com.swagger.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.config.EmptyResultDataAccessException;
import com.swagger.model.Employee;
import com.swagger.service.EmployeeService;



@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	//to add the data 
	@PostMapping("/add")
public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		Employee addEmployees = this.employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(addEmployees,HttpStatus.CREATED);
}
	//to fetch all data
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Employee>> findAll(){
	List<Employee> employee = this.employeeService.getAll();
	return new ResponseEntity<List<Employee>> (employee, HttpStatus.OK);
	
	}
	//to fetch single data
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Employee> findSingle(@PathVariable long id) throws NoSuchElementException{
		
	Employee findFirst = this.employeeService.getSingleEmployee(id);
	return new ResponseEntity<Employee>(findFirst,HttpStatus.OK);
	}
	
	//	to update data
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateContact(@PathVariable long id,@Valid @RequestBody Employee employee){
		Employee employee2 = this.employeeService.updateEmployee(employee, id);
		
				return new ResponseEntity<Employee>(employee2,HttpStatus.ACCEPTED);
				
	}
@DeleteMapping("/delete/{id}")
	
	public ResponseEntity< String> deleteEmployee(@PathVariable long id) throws EmptyResultDataAccessException {
		this.employeeService.deleteEmployee(id);
		return new ResponseEntity<>( "Employee deleted successfully:"+id,HttpStatus.OK);
	}
}	
	
	
	
	
	
	
	
	
	

