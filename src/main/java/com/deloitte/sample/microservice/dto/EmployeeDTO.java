package com.deloitte.sample.microservice.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.deloitte.sample.microservice.constant.MessageConstant;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    
	@JsonProperty(access=Access.READ_ONLY)
	private String id;
	
	@NotNull
	@NotEmpty(message=MessageConstant.MUST_HAVE_VALID_VALUE)
	private String firstName;
   
	@NotNull
	@NotEmpty(message=MessageConstant.MUST_HAVE_VALID_VALUE)
	private String lastName;
   
	@NotNull
	private int age;
   
	@NotNull
	@NotEmpty(message=MessageConstant.MUST_HAVE_VALID_VALUE)
	private String phNumber;
    
	@NotNull
	@NotEmpty(message=MessageConstant.MUST_HAVE_VALID_VALUE)
	private String emailId;
	
}
