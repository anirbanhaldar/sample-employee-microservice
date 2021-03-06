package com.haldar.sample.microservice.service;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.haldar.sample.microservice.domain.Employee;
import com.haldar.sample.microservice.dto.EmployeeDTO;

@Component
public class EmployeeMapper {

	public Employee mapEmployee(EmployeeDTO employeeDTO,Employee employee) {
	  if(employee.getId()==null) {	
		employee.setId(UUID.randomUUID().toString());
       }
	  employee.setAge(employeeDTO.getAge());
	  employee.setFirstName(employeeDTO.getFirstName());
	  employee.setLastName(employeeDTO.getLastName());
	  employee.setPhNumber(employeeDTO.getPhNumber());
	  employee.setEmailId(employeeDTO.getEmailId());
	  return employee;
}
}
