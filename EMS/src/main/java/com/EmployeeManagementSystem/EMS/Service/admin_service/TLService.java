package com.EmployeeManagementSystem.EMS.Service.admin_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.TL;
import com.EmployeeManagementSystem.EMS.Repository.admin_repository.TLRepository;

@Service
public class TLService {
    @Autowired
    private TLRepository tlRepository;

    // Get all TLs
    public List<TL> getAllTL() {
        return tlRepository.findAll();
    }

    // Add a new TL
    public void addTL(TL tl) {
        tlRepository.save(tl);
    }

    public void deleteTL(Long id) {
        tlRepository.deleteById(id);
    }
}
