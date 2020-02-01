package com.haldar.sample.microservice.domain;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@XmlRootElement
@Data
public class RESTAPIErrorInfo {
	private  String errorDetail;
	private  String errorMessage;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	private RESTAPIErrorInfo() {
	       timestamp = LocalDateTime.now();
	   }

	public RESTAPIErrorInfo(Exception ex, String detail) {
		this();
		this.errorMessage = ex.getLocalizedMessage();
		this.errorDetail = detail;
		
	}
	
	
}