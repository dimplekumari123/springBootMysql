package com.hcl.springbootmysql.service;

import java.util.List;

import com.hcl.springbootmysql.entity.Employee;


public interface EmployeeService {

	Employee addEmployee(Employee employee);
	
	List<Employee> getAll();

	Employee getById(Long empId);

	List<Employee> getAllByPage(int pageNumber, int pageSize);

	List<Employee> getAllByfnameSort();

	List<Employee> getAllOrderByFirstNameAsc(String firstName);

	List<?> getAnalytics();

	List<?> getAgeByName(String firstName, String lastName);

	List<Employee> getAgeByNameNative(String firstName, String lastName);

}
