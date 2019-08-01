package com.deloitte.sample.microservice.dao.jpa;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.sample.microservice.domain.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {

	List<Employee> findEmployeeByLastName(String lastName);

}
