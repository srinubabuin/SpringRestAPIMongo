package com.app.spring.rest.mongo.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.spring.rest.mongo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String>{
	
	@Override
	Employee findOne(String id);
	
	@Override
	void delete(Employee employee);

}
