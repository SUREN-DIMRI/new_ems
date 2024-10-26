package com.EmployeeManagementSystem.EMS.Controller.admin_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; // Import PathVariable for capturing URI variables
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeManagementSystem.EMS.Entity.admin_entity.HR;
import com.EmployeeManagementSystem.EMS.Service.admin_service.HRService;

@Controller
public class HRController {

    @Autowired
    private HRService hrService;

    @GetMapping("/admin/hr")
    public String getHR(Model model) {
        List<HR> hrList = hrService.getALLHR();
        model.addAttribute("hrList", hrList);
        return "hr"; // This will map to hr.html
    }

    @PostMapping("/addHR")
    public String addHR(
        @RequestParam("name") String name,
        @RequestParam("department") String department,
        @RequestParam("email") String email
    ) {
        HR newHR = new HR();
        newHR.setName(name);
        newHR.setDepartment(department);
        newHR.setEmail(email);
        hrService.addHR(newHR);
        return "redirect:/admin/hr"; // Redirects back to the HR list page
    }

    @PostMapping("/update/{id}") // Corrected the mapping for updating HR
    public String updateHR(
        @PathVariable Long id,
        @RequestParam("name") String name,
        @RequestParam("department") String department,
        @RequestParam("email") String email
    ) {
        HR updatedHR = new HR();
        updatedHR.setId(id);
        updatedHR.setName(name);
        updatedHR.setDepartment(department);
        updatedHR.setEmail(email);
        hrService.updateHR(updatedHR);
        return "redirect:/admin/hr"; // Redirects back to the HR list page
    }

    @PostMapping("/hr/delete/{id}") // Updated the route to delete an HR entry with path variable
    public String deleteHR(@PathVariable Long id) {
        hrService.deleteHR(id);
        return "redirect:/admin/hr"; // Redirects back to the HR list page
    }

    @GetMapping("/hr/editHR/{id}") // Updated to include the PathVariable in the URL
    public String editHR(@PathVariable Long id, Model model) {
        HR hr = hrService.getHRById(id);
        model.addAttribute("hr", hr); // This line passes the HR object to the view
        return "editHR"; // This should match your HTML file name without the extension
    }
}
