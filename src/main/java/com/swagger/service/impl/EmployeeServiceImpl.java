package com.swagger.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.swagger.config.EmptyResultDataAccessException;
import com.swagger.model.Employee;
import com.swagger.repository.EmployeeRepository;
import com.swagger.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getSingleEmployee(long id) throws NoSuchElementException {
		try {
		return employeeRepository.findById(id).get();
		}
		catch(Exception e) {
			throw new NoSuchElementException ("Employee not found with id "+id);
		}
	}

	@Override
	public Employee updateEmployee(Employee empployee, long id) {
		Employee updateEmp = employeeRepository.findById(id).get();
		updateEmp.setName(empployee.getName());
		updateEmp.setEmail(empployee.getEmail());
		updateEmp.setAge(empployee.getAge());
		return employeeRepository.save(updateEmp);
	}

	@Override
	public void deleteEmployee(long id)throws EmptyResultDataAccessException {
		try {
		employeeRepository.deleteById(id);
		}catch(Exception e) {
			throw new EmptyResultDataAccessException("No employee found with ID " + id,1);

		}
		
		
	}
	
	
	
}
