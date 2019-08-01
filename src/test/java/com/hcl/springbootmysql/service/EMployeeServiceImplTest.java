package com.hcl.springbootmysql.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.springbootmysql.entity.Employee;
import com.hcl.springbootmysql.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EMployeeServiceImplTest {
	
	@MockBean
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	static List<Employee> employees = new ArrayList<>();
	
	@BeforeClass
	public static void setUp(){
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("test1");
		employee.setLastName("lname1");
		employees.add(employee);
		
		employee = new Employee();
		employee.setId(2L);
		employee.setFirstName("test2");
		employee.setLastName("lname2");
		employees.add(employee);
	}
	
	@Test
	public void test(){
		when(employeeRepository.findAll()).thenReturn(employees);
		List<Employee> employees = employeeServiceImpl.getAll();
		assertNotNull(employees);
		assertEquals(employees.size(), 2);
	}

}
