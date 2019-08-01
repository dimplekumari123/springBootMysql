package com.hcl.springbootmysql.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.springbootmysql.entity.Employee;
import com.hcl.springbootmysql.repository.EmployeeRepository;


@RunWith(MockitoJUnitRunner.class)
public class EMployeeServiceImplMockitoTest {
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;
	
	static List<Employee> employees = new ArrayList<>();
	
	static Employee saveEmployee = new Employee();
	
	static Employee employee = null;
	
	@BeforeClass
	public static void setUp(){
		employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("test1");
		employee.setLastName("lname1");
		employees.add(employee);
		
		employee = new Employee();
		employee.setId(2L);
		employee.setFirstName("test2");
		employee.setLastName("lname2");
		employees.add(employee);
		
		saveEmployee.setFirstName("fname");
		
	}
	
	@Test
	public void testGetAll(){
		when(employeeRepository.findAll()).thenReturn(employees);
		List<Employee> employees = employeeServiceImpl.getAll();
		assertNotNull(employees);
		assertEquals(employees.size(), 2);
	}
	
	@Test
	public void testGetById(){
		Optional<Employee> employees = Optional.of(new Employee(1L, "test"));
		when(employeeRepository.findById(Mockito.anyLong())).thenReturn(employees);
		Employee employee = employeeServiceImpl.getById(1L);
		assertNotNull(employee);
		assertEquals(employee.getFirstName(), "test");
	}
	
	@Test
	public void testAdd(){
		when(employeeRepository.save(saveEmployee)).thenReturn(employee);
		Employee e = employeeServiceImpl.addEmployee(saveEmployee);
		assertNotNull(e);
		assertEquals(e.getFirstName(), "test2");
	}

}
