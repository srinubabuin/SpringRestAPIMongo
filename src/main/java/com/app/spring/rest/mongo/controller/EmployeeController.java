package com.app.spring.rest.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.spring.rest.mongo.model.Employee;
import com.app.spring.rest.mongo.repo.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRespository;
	
	@RequestMapping(method=RequestMethod.POST, value="/employees/save")
	public String saveEmployee(@RequestBody Employee emp) {
		
		employeeRespository.save(emp);
		return emp.getId();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/employees/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		
		return employeeRespository.findOne(id); 
	}
	
	@RequestMapping(method=RequestMethod.GET, value= "/employees")
	public Iterable<Employee> getAllEmployees(){
		
		
		return employeeRespository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/employees/update/{id}")
	public Employee updateEmployee(@PathVariable String id, @RequestBody Employee emp) {
		Employee employee = employeeRespository.findOne(id);
		
		if(emp.getName() != null) {
			
			employee.setName(emp.getName());
		}
		if(emp.getDept() != null) {
			employee.setDept(emp.getDept());
		}
		employeeRespository.save(employee);
		return employee;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/delete/{id}")
	public String deleteEmployee(@PathVariable String id) {
		
		Employee emp = employeeRespository.findOne(id);
		employeeRespository.delete(emp);
		
		return "Employee deleted successfully.";
	}
	
}
