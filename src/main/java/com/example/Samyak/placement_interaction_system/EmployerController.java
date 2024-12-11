package com.example.Samyak.placement_interaction_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployerController {

    @Autowired
    private JobRepository jobRepository;

    // Mapping for the employer dashboard
    @GetMapping("/employerDashboard")
    public String employerDashboard(Model model) {
        // Optional: Fetch and display the list of jobs posted
        model.addAttribute("jobs", jobRepository.findAll());
        return "employerDashboard";  // Returns employerDashboard.html
    }

    // Mapping to display the job posting form
    @GetMapping("/postJob")
    public String showPostJobForm() {
        return "postJob";  // Returns postJob.html
    }

    // Mapping to handle job posting
    @PostMapping("/postJob")
    public String postJob(@RequestParam("jobTitle") String title,
                          @RequestParam("description") String description,
                          @RequestParam("eligibility") String eligibility,
                          @RequestParam("location") String location,
                          @RequestParam("salary") String salary,
                          Model model) {
        // Save job to the database
        Job job = new Job();
        job.setTitle(title);
        job.setDescription(description);
        job.setLocation(location);
        job.setSalary(salary);

        jobRepository.save(job);

        // Add success message to the model
        model.addAttribute("successMessage", "Job posted successfully!");

        // Redirect to the employer dashboard
        return "redirect:/employerDashboard";  // Redirects to employerDashboard with the new job posted
    }

    // Mapping for logout
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login"; // Redirect to the login page after logout
    }
}  