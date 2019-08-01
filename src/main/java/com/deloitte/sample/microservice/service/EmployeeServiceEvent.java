package com.deloitte.sample.microservice.service;

import org.springframework.context.ApplicationEvent;

import com.deloitte.sample.microservice.domain.Employee;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This is an optional class used in publishing application events. This can be
 * used to inject events into the Spring Boot audit management endpoint.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class EmployeeServiceEvent extends ApplicationEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2822008402402709327L;
	Employee eventEmployee;
	String eventType;

	public EmployeeServiceEvent(Object source, String eventType,  Employee employee) {
		super(source);
		this.eventType = eventType;
		this.eventEmployee = employee;
	}


	
}
