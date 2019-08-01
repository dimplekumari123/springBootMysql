package com.hcl.springbootmysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hcl.springbootmysql.entity.Employee;
import com.hcl.springbootmysql.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee){
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> employees = employeeRepository.findAll();
		
		return employees;
	}

	@Override
	public Employee getById(Long empId) {
		//return employeeRepository.findById(empId).orElse(null);
		Optional<Employee> employees = employeeRepository.findById(empId);
		if(employees.isPresent()){
			Employee employee = employees.get();
			return employee;
		}
		return null;
	}
	
	@Override
	public List<Employee> getAllOrderByFirstNameAsc(String firstName) {
		return employeeRepository.findByFirstNameContainsAllIgnoreCaseOrderByFirstNameDesc(firstName);
	}
	
	@Override
	public List<Employee> getAllByfnameSort() {
		return employeeRepository.findAll(new Sort(Sort.Direction.ASC, "firstName"));
	}
	
	@Override
	public List<Employee> getAllByPage(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, new Sort(Sort.Direction.ASC, "firstName")
        .and(new Sort(Sort.Direction.ASC, "lastName")));
		return employeeRepository.findAll(pageable).getContent();
	}
	
	@Override
	public List<?> getAnalytics(){
		return employeeRepository.getAnalytics();
	}
	
	@Override
	public List<?> getAgeByName(String firstName, String lastName){
		return employeeRepository.getAgeByName(firstName, lastName);
	}

	@Override
	public List<Employee> getAgeByNameNative(String firstName, String lastName) {
		return employeeRepository.getAgeByNameNative(firstName, lastName);
	}

}
