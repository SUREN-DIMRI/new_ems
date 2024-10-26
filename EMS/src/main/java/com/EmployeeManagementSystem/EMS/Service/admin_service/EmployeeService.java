package com.EmployeeManagementSystem.EMS.Service.admin_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.Employee;
import com.EmployeeManagementSystem.EMS.Repository.admin_repository.EmployeeRepository;

import java.util.*;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(); // Fetch all employees from the database
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
}
