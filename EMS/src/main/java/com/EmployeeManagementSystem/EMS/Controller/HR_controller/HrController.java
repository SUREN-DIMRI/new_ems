package com.EmployeeManagementSystem.EMS.Controller.HR_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.EmployeeManagementSystem.EMS.Service.hr_service.HRManagementService;



@Controller
public class HrController {

    @GetMapping("/hr_login")
    public String showHrLoginPage() {
        return "hr_login";
    }
    
    @Autowired
    private HRManagementService hrManagementService;

    @PostMapping("/hr/authenticate")
    public String authenticateHR(
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        Model model
    ) {
        // Check if the username exists in the HR table and password matches email
        boolean isAuthenticated = hrManagementService.verifyHR(username, password);
        if (isAuthenticated) {
            return "redirect:/hr_dashboard";  // Redirect to HR dashboard upon successful login
        }
        model.addAttribute("error", "Invalid username or password.");
        return "hr_login";
    }

    @GetMapping("/hr_dashboard")
    public String hrDashboard(Model model) {
        // Fetch employee data to populate the dashboard
        // model.addAttribute("totalEmployees", employeeService.getTotalEmployees());
        // model.addAttribute("totalDepartments", departmentService.getTotalDepartments());
        return "hr_dashboard"; // Name of the HTML file without extension
    }
    
}
