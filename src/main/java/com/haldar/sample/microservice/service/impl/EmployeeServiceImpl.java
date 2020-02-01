package com.haldar.sample.microservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.haldar.sample.microservice.amqp.RabbitMQSender;
import com.haldar.sample.microservice.constant.MessageConstant;
import com.haldar.sample.microservice.dao.jpa.EmployeeRepository;
import com.haldar.sample.microservice.domain.Employee;
import com.haldar.sample.microservice.exception.ResourceNotFoundException;
import com.haldar.sample.microservice.service.EmployeeService;
import com.haldar.sample.microservice.util.LogUtility;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Data
@NoArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
//	@Autowired
//	private RabbitMQSender messageSender;
	

	public Employee createPerson(Employee employee) {
		log.info(MessageConstant.LOGGING_INFO + LogUtility.getCurrentMethodName());
		Employee employeefromDB= employeeRepository.save(employee);
	//	messageSender.send(employeefromDB);
		return employeefromDB;
	}

	public Employee getPerson(String id) throws ResourceNotFoundException {
		log.info(MessageConstant.LOGGING_INFO + LogUtility.getCurrentMethodName());
		
		if(employeeRepository.findById(id).get()==null) {
			throw new ResourceNotFoundException(MessageConstant.RESOURCE_NOT_FOUND + " with given id " + id);
		}
		
		return employeeRepository.findById(id).get();
	}

	public Employee updatePerson(Employee employee) throws ResourceNotFoundException {
		if(employeeRepository.findById(employee.getId()).get()==null) {
			throw new ResourceNotFoundException(MessageConstant.RESOURCE_NOT_FOUND + " with given id " + employee.getId());
		}
		log.info(MessageConstant.LOGGING_INFO + LogUtility.getCurrentMethodName());
		Employee employeefromDB= employeeRepository.save(employee);
	//	messageSender.send(employeefromDB);
		return employeefromDB;
	}

	public String deletePerson(String id) throws ResourceNotFoundException {
		log.info(MessageConstant.LOGGING_INFO + LogUtility.getCurrentMethodName());
		if(employeeRepository.findById(id).get()==null) {
			throw new ResourceNotFoundException(MessageConstant.RESOURCE_NOT_FOUND + " with given id " + id);
		}
		
		employeeRepository.deleteById(id);
		return id;
	}

	
}
