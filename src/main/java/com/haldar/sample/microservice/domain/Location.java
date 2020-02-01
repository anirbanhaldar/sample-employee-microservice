package com.haldar.sample.microservice.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LOCATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
@EntityListeners(AuditingEntityListener.class)
public class Location {
    
	@Id
	private String locId;
	private String houseNo;
	private String StreetAddress;
	private String postalCode;
	private String area;
	private String city;
	private String coOrdinate;
	private String state;
	private String country;
	
	
}
