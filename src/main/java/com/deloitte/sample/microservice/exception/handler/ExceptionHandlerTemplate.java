package com.deloitte.sample.microservice.exception.handler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.deloitte.sample.microservice.domain.RESTAPIErrorInfo;
import com.deloitte.sample.microservice.exception.HTTP400Exception;
import com.deloitte.sample.microservice.exception.HTTP404Exception;
import com.deloitte.sample.microservice.exception.ResourceNotFoundException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Data
@ControllerAdvice
@EqualsAndHashCode(callSuper=false)
@Slf4j
public class ExceptionHandlerTemplate {


	@ExceptionHandler(HTTP400Exception.class)
	public ResponseEntity<RESTAPIErrorInfo> handleDataStoreException(HTTP400Exception ex, WebRequest request,
			HttpServletResponse response) {
		log.info("Converting Data Store exception to RestResponse : " + ex.getMessage());
		RESTAPIErrorInfo restapiErrorInfo=new RESTAPIErrorInfo(ex,"You messed up." );
		return new ResponseEntity<RESTAPIErrorInfo>(restapiErrorInfo, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<RESTAPIErrorInfo> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request,
			HttpServletResponse response) {
		log.info("ResourceNotFoundException handler:" + ex.getMessage());
		RESTAPIErrorInfo restapiErrorInfo=new RESTAPIErrorInfo(ex,"Sorry I couldn't find it." );
		return new ResponseEntity<RESTAPIErrorInfo>(restapiErrorInfo, HttpStatus.NOT_FOUND);
	}
	
	
	
}
