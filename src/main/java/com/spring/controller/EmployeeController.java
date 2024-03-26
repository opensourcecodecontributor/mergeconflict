package com.spring.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Employee;
import com.spring.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// http://localhost:8080/employees
	@PostMapping
	public ResponseEntity<List<Employee>> saveEmployee(@RequestBody List<Employee> employees) {
		List<Employee> savedEmployees = employeeService.saveEmployee(employees);
		return new ResponseEntity<>(savedEmployees, HttpStatus.CREATED);
	}

	// http://localhost:8080/employees
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	// http://localhost:8080/employees
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Optional<Employee> employee = employeeService.getAllEmployeesById(id);
		return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// http://localhost:8080/employees/1
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable int id) {
		employeeService.deleteEmployeesById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
