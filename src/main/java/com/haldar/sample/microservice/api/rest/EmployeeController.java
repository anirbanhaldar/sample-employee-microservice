package com.haldar.sample.microservice.api.rest;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haldar.sample.microservice.constant.Constants;
import com.haldar.sample.microservice.constant.MessageConstant;
import com.haldar.sample.microservice.dao.jpa.EmployeeRepository;
import com.haldar.sample.microservice.domain.Employee;
import com.haldar.sample.microservice.dto.EmployeeDTO;
import com.haldar.sample.microservice.exception.ResourceNotFoundException;
import com.haldar.sample.microservice.service.EmployeeMapper;
import com.haldar.sample.microservice.service.EmployeeService;
import com.haldar.sample.microservice.service.EmployeeServiceEvent;
import com.haldar.sample.microservice.util.LogUtility;

import lombok.extern.slf4j.Slf4j;


/**
 * @author ahaldar
 *
 */
@RestController
@Slf4j
@RequestMapping(value = "/employeeService")
public class EmployeeController extends AbstractRestHandler {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeMapper mapper;
	
	@PostMapping(value=Constants.EMPLOYEE,produces=Constants.APPLICATION_JSON)
	public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeDTO employee){
		Employee newEmployee=new Employee();
		newEmployee=mapper.mapEmployee(employee, newEmployee);
	    Employee employeafterSave= employeeService.createPerson(newEmployee);
	    log.info(MessageConstant.LOGGING_INFO + LogUtility.getCurrentMethodName());
	    eventPublisher.publishEvent(new EmployeeServiceEvent(this, "EmployeeCreated", employeafterSave));
	    return new ResponseEntity<>(employeafterSave,HttpStatus.CREATED);
		
	}
	
	@PutMapping(value=Constants.EMPLOYEE+"/{employeeId}",produces=Constants.APPLICATION_JSON)
	public ResponseEntity<Employee>  updateEmployee(@RequestBody EmployeeDTO employee,@PathVariable(name="employeeId") String employeeId ) throws ResourceNotFoundException{
		Optional<Employee> employeefromDb=employeeRepository.findById(employeeId);
		if(!employeefromDb.isPresent()) {
			throw new ResourceNotFoundException(MessageConstant.RESOURCE_NOT_FOUND + " with id " + employeeId);
		}
		Employee employeeaftermapped = mapper.mapEmployee(employee, employeefromDb.get());
	    Employee employeafterSave= employeeService.updatePerson(employeeaftermapped);
	    log.info(MessageConstant.LOGGING_INFO + LogUtility.getCurrentMethodName());
	    eventPublisher.publishEvent(new EmployeeServiceEvent(this, "EmployeeUpdated", employeafterSave));
	    return new ResponseEntity<>(employeafterSave,HttpStatus.OK);
		
	}
	
	@GetMapping(value=Constants.EMPLOYEE+"/{employeeId}",produces=Constants.APPLICATION_JSON)
	public ResponseEntity<Employee>  updateEmployee(@PathVariable(name="employeeId") String employeeId ) throws ResourceNotFoundException{
	    Employee employeafterSave= employeeService.getPerson(employeeId);
	    log.info(MessageConstant.LOGGING_INFO + LogUtility.getCurrentMethodName());
	    return new ResponseEntity<>(employeafterSave,HttpStatus.OK);		
	}
	
	@GetMapping(value=Constants.EMPLOYEE+"/{emailId}",produces=Constants.APPLICATION_JSON)
	public ResponseEntity<Employee> getByEmailId(@PathVariable(name="emailId") String emailId) throws ResourceNotFoundException{
		
		Employee employee= employeeRepository.findByEmailId(emailId);
		if(employee==null) {
			throw new ResourceNotFoundException(MessageConstant.RESOURCE_NOT_FOUND + " with mail id " + emailId);
		}
		return new ResponseEntity<>(employee,HttpStatus.OK);
		
	}
	
	

   
	
}
