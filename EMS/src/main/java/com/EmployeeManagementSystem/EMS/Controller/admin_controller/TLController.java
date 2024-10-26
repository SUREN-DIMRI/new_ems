package com.EmployeeManagementSystem.EMS.Controller.admin_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import com.EmployeeManagementSystem.EMS.Entity.admin_entity.TL;
import com.EmployeeManagementSystem.EMS.Service.admin_service.TLService;

@Controller
public class TLController {
    
    @Autowired
    private TLService tlService;

    @GetMapping("/admin/tl")
    public String getTL(Model model) {
        List<TL> tlList = tlService.getAllTL();
        model.addAttribute("tlList", tlList);
        return "tl"; // This will map to tl.html
    }
    
    @PostMapping("/addTL")
    public String addTL(
        @RequestParam("name") String name,
        @RequestParam("department") String department,
        @RequestParam("email") String email,
        Model model // Add Model parameter here
    ) {
        TL newTL = new TL();
        newTL.setName(name);
        newTL.setDepartment(department);
        newTL.setEmail(email);
        tlService.addTL(newTL); // Make sure this method is defined in TLService
        
        // Fetch updated list after adding the new TL
        List<TL> tlList = tlService.getAllTL();
        model.addAttribute("tlList", tlList);
        
        // You could return to the same view or redirect as needed
        return "tl"; // This will display the updated TL list on the same page
    }
    
    @PostMapping("/tl/delete/{id}")
    public String deleteTL(@PathVariable("id") Long id) {
        tlService.deleteTL(id); // Make sure this method is defined in TLService
        return "redirect:/admin/tl"; // Redirects back to the TL list page after deletion
    }
}
