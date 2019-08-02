package com.deloitte.sample.microservice.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.sample.microservice.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	List<Employee> findEmployeeByLastName(String lastName);

}
