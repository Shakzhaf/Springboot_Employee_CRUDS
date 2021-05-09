package com.shakz.springboot.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shakz.springboot.employee.service.EmployeeService;
import com.shakz.springboot.employee.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees")
	public List<EmployeeRepository> getEmployees() {
		return employeeService.getEmployees();
	}

	@RequestMapping("/employees/{id}")
	public EmployeeRepository getEmployee(@PathVariable String id) {
		return employeeService.getEmployee(Integer.parseInt(id));	
	}

	@RequestMapping(method = RequestMethod.POST, value="/employees")
	public void addEmployee(@RequestBody EmployeeRepository employee) {
		employeeService.addEmployee(employee);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/updateEmployees")
	public void updateEmployee(@RequestBody EmployeeRepository employee) {
		employeeService.updateEmployee(employee);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/deleteEmployee")
	public void deleteEmployee(@RequestBody EmployeeRepository employee) {
		employeeService.deleteEmployee(employee);
	}
	
}
