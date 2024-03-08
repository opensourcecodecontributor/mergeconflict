package com.spring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Employee;
import com.spring.repository.EmployeeRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<Employee> saveEmployee(List<Employee> employee) {
		return employeeRepo.saveAll(employee);
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	
	public Optional<Employee> getAllEmployeesById(int id) {
		return employeeRepo.findById(id);
	}
	
	public void deleteEmployeesById(int id) {
		employeeRepo.deleteById(id);
	}
	
	public void updateEmployeeById(int id, Employee updatedEmployeeData) {
        // Retrieve the employee from the database
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);

        if (optionalEmployee.isPresent()) {
            // If the employee exists, update its attributes
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setFirstname(updatedEmployeeData.getFirstname());
            existingEmployee.setLastName(updatedEmployeeData.getLastName());
            existingEmployee.setPhone(updatedEmployeeData.getPhone());
            existingEmployee.setLastLoginTime(updatedEmployeeData.getLastLoginTime());

            // Save the updated employee back to the database
            employeeRepo.save(existingEmployee);
        } else {
            // Handle the case where the employee with the given ID doesn't exist
            throw new RuntimeException("Employee with ID " + id + " not found");
        }
    }
	
	public Employee partialEmployeeUpdateById(int id, Employee request) {
	    Optional<Employee> optionalEmployee = employeeRepo.findById(id);
	    if (optionalEmployee.isPresent()) {
	        Employee employee = optionalEmployee.get();

	        if (request.getFirstname() != null) {
	            employee.setFirstname(request.getFirstname());
	        }
	        if (request.getLastName() != null) {
	            employee.setLastName(request.getLastName());
	        }
	        if (request.getPhone() != null) {
	            employee.setPhone(request.getPhone());
	        }
	        employee.setLastLoginTime(LocalDateTime.now()); // Update last login time

	        // Save the updated employee back to the database
	        return employeeRepo.save(employee);
	    } else {
	        // Handle case when employee with given id is not found
	        throw new RuntimeException("Employee with ID " + id + " not found");
	    }
	}


}
