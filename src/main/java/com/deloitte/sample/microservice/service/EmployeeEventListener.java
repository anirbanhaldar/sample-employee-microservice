package com.deloitte.sample.microservice.service;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmployeeEventListener implements ApplicationListener<EmployeeServiceEvent> {

	public void onApplicationEvent(EmployeeServiceEvent event) {
		EmployeeServiceEvent employeeEvent = (EmployeeServiceEvent) event;
		log.info("Employee " + event.getEventType() + " with details : " + employeeEvent.getEventEmployee());
	}
}
