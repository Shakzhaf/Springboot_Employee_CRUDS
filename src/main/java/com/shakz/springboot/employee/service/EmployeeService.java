package com.shakz.springboot.employee.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shakz.springboot.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private List<EmployeeRepository> employees 
			= new ArrayList<>(Arrays.asList(
					new EmployeeRepository(1, "Shakz", 22,1d), 
					new EmployeeRepository(2, "Vivek", 27,2d),
					new EmployeeRepository(3, "Gaurav", 35,3d)));

	public List<EmployeeRepository> getEmployees() {
		System.out.println("EmployeeService.getEmployees() invoked " + employees );
		return employees;
	}
	
	public EmployeeRepository getEmployee(int id) {
		System.out.println("EmployeeService.getEmployee(id) invoked " + id );
		return employees.stream().filter(t -> t.getId() == id).findFirst().get();
	}

	public void addEmployee(EmployeeRepository employee) {
		employees.add(employee);
		System.out.println("EmployeeService.addEmployee() invoked " + employee);
	}

	public void updateEmployee(EmployeeRepository employee) {
		System.out.println("EmployeeService.updateEmployee() invoked " + employee);
	}

	public void deleteEmployee(int id) {
		System.out.println("EmployeeService.deleteEmployee() invoked " + id);
	}

}
