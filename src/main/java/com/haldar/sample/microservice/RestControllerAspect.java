package com.haldar.sample.microservice;

import java.util.NoSuchElementException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class RestControllerAspect {

	@Before("execution(public * com.haldar.sample.microservice.api.rest.*Controller.*(..))")
	public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
		log.info(":::::AOP Before REST call:::::" + pjp);
	}

	@AfterReturning("execution(public * com.haldar.sample.microservice.api.rest.*Controller.createPerson*(..))")
	public void afterCallingCreatePerson(JoinPoint pjp) {
		log.info(":::::AOP @AfterReturning Create REST call:::::" + pjp);
	}

	@AfterReturning("execution(public * com.haldar.sample.microservice.api.rest.*Controller.getAllPerson*(..))")
	public void afterCallinggetAllPerson(JoinPoint pjp) {
		log.info(":::::AOP @AfterReturning getAllPerson REST call:::::" + pjp);
	}

	@AfterReturning("execution(public * com.haldar.sample.microservice.api.rest.*Controller.getPerson*(..))")
	public void afterCallinggetPerson(JoinPoint pjp) {
		log.info(":::::AOP @AfterReturning getPErson REST call:::::" + pjp);
	}

	@AfterReturning("execution(public * com.haldar.sample.microservice.api.rest.*Controller.updatePerson*(..))")
	public void afterCallingupdatePerson(JoinPoint pjp) {
		log.info(":::::AOP @AfterReturning update PErson REST call:::::" + pjp);
	}

	@AfterThrowing(pointcut = "execution(public * com.haldar.sample.microservice.api.rest.*Controller.*(..))", throwing = "e")
	public void afterGetGreetingThrowsException(NoSuchElementException e) {

	}
}
