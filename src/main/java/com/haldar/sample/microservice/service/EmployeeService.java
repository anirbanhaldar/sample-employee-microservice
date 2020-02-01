package com.haldar.sample.microservice.service;

import com.haldar.sample.microservice.domain.Employee;
import com.haldar.sample.microservice.exception.ResourceNotFoundException;

public interface EmployeeService {
  
	public Employee createPerson(Employee employee);
	public Employee getPerson(String id) throws ResourceNotFoundException;
	public Employee updatePerson(Employee person) throws ResourceNotFoundException;
	public String deletePerson(String id) throws ResourceNotFoundException;
}
