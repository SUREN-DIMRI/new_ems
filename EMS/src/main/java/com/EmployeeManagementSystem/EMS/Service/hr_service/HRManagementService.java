package com.EmployeeManagementSystem.EMS.Service.hr_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.EMS.Repository.hr_repository.HRManagementRepository;


@Service
public class HRManagementService {
    
    @Autowired
    private HRManagementRepository hrManagementRepository;

    public boolean verifyHR(String username, String password) {
        return hrManagementRepository.existsByNameAndEmail(username, password);
    }
}
