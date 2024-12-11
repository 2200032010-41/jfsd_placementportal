package com.example.Samyak.placement_interaction_system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    // Admin Dashboard
    @GetMapping(path="/admin")
    public String adminDashboard() {
        return "adminDashboard";  // Returns adminDashboard.html
    }

    // Manage Users
    @GetMapping(path="/managemyUsers")
    public String manageUsers() {
        return "manageusers";  // Returns manageUsers.html
    }

    // Manage Jobs
    @GetMapping(path="/manageJobs")
    public String manageJobs() {
        return "manageJobs";  // Returns manageJobs.html
    }

    // Generate Reports
    @GetMapping(path="/generateReports")
    public String generateReports() {
        return "generateReports";  // Returns generateReports.html
    }

    // Additional admin functionalities, like managing user roles, viewing reports, etc.
}
