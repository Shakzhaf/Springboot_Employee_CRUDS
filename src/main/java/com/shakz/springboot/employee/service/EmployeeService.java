package com.shakz.springboot.employee.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.shakz.springboot.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private List<EmployeeRepository> employees 
			= new ArrayList<>(Arrays.asList(
					new EmployeeRepository(1, "Shakz", 22, 1d), 
					new EmployeeRepository(2, "Vivek", 27, 2d),
					new EmployeeRepository(3, "Gaurav", 35, 3d)));

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
		for (final EmployeeRepository e : employees) {
	        // Access properties of person, usage of getter methods would be good
	        if (e.getId() == employee.getId()) {
	            // Found matching person
	        	System.out.println("EmployeeService.updateEmployee() invoked " + employee.getId());
	        	employees.remove(e);
	        	employees.add(employee);
	        }
	        else {
	        	System.out.println("Could not find employee id " + employee.getId());
	        }
	    }
	}

	public void deleteEmployee(EmployeeRepository employee) {
//		for (final EmployeeRepository e : employees) {
//			if (e.getId() == employee.getId()) {
//	            // Found matching person
//	        	System.out.println("EmployeeService.deleteEmployee() invoked " + employee.getId());
//	        	employees.remove(e);
//	        }
//	        else {
//	        	System.out.println("Could not find employee id " + employee.getId());
//	        }	
//		}
		
		for(Iterator<EmployeeRepository> iterator = employees.iterator(); iterator.hasNext(); ) {
			EmployeeRepository emp = iterator.next();
			if(emp.getId() == employee.getId()) {
				int id = emp.getId();
				//System.out.println("EmployeeService.deleteEmployee() invoked " + employee.getId());
				iterator.remove();
			}else {
	        	System.out.println("Could not find employee id " + employee.getId());
	        }
			
			//employees.remove(iterator)
		}
		
		
	}

}
