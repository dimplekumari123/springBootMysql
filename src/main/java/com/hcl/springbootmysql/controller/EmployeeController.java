package com.hcl.springbootmysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.springbootmysql.domain.EmployeesResponse;
import com.hcl.springbootmysql.entity.Employee;
import com.hcl.springbootmysql.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@PostMapping("")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
		return new ResponseEntity<String>("employee added successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public EmployeesResponse getAll(){
		List<Employee> employees = employeeService.getAll();
		EmployeesResponse employeesResponse = new EmployeesResponse();
		employeesResponse.setEmployees(employees);
		employeesResponse.setStatusCode(200);
		employeesResponse.setStatusMessage("Success");
		return employeesResponse;
	}
	
	@GetMapping("/{empId}")
	public EmployeesResponse getById(@PathVariable Long empId){
		Employee employee = employeeService.getById(empId);
		EmployeesResponse employeesResponse = new EmployeesResponse();
		employeesResponse.setEmployee(employee);
		employeesResponse.setStatusCode(200);
		employeesResponse.setStatusMessage("Success");
		return employeesResponse;
	}
	
	@GetMapping("/page")
	public EmployeesResponse getAllByPage(@RequestParam int pageNumber, @RequestParam int pageSize){
		List<Employee> employees = employeeService.getAllByPage(pageNumber, pageSize);
		EmployeesResponse employeesResponse = new EmployeesResponse();
		employeesResponse.setEmployees(employees);
		employeesResponse.setStatusCode(200);
		employeesResponse.setStatusMessage("Success");
		return employeesResponse;
	}
	
	@GetMapping("/order/{firstName}")
	public EmployeesResponse getAllOrderByName(@PathVariable String firstName){
		List<Employee> employees = employeeService.getAllOrderByFirstNameAsc(firstName);
		EmployeesResponse employeesResponse = new EmployeesResponse();
		employeesResponse.setEmployees(employees);
		employeesResponse.setStatusCode(200);
		employeesResponse.setStatusMessage("Success");
		return employeesResponse;
	}
	
	@GetMapping("/analytics")
	public List<?> getAnalytics(){
		return employeeService.getAnalytics();
	}
	
	@GetMapping("/agebyname")
	public List<?> getAgeByName(@RequestParam String firstName, @RequestParam String lastName){
		return employeeService.getAgeByName(firstName, lastName);
	}
	
	@GetMapping("/bynamenative")
	public List<Employee> getAgeByNameNative(@RequestParam String firstName, @RequestParam String lastName){
		return employeeService.getAgeByNameNative(firstName, lastName);
	}
}
