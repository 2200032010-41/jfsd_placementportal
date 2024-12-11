package com.example.Samyak.placement_interaction_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobApplicationRepository jobApplicationRepository; // Assuming you have a repository for JobApplication

    // Mapping to show the job application form
    @GetMapping("/apply/{id}")
    public String showApplyJobForm(@PathVariable Long id, Model model) {
        model.addAttribute("jobId", id); // Pass the job ID to the view
        model.addAttribute("application", new JobApplication()); // Pass a new application object to the view
        return "applyJob"; // This maps to applyJob.html
    }

    // Mapping to handle the job application form submission
    @PostMapping("/applyJob/{id}")
    public String submitJobApplication(
            @PathVariable Long id,
            @ModelAttribute("application") JobApplication application,
            Model model) {
        try {
            application.setJobId(id); // Set the job ID in the application
            application.setApplicationDate(LocalDate.now()); // Set the current date as the application date
            application.setStatus("Processing"); // Default status when application is submitted

            // Save the application to the repository (database or temporary list)
            jobApplicationRepository.save(application); // Save to database

            // Log the application details (for testing purposes)
            System.out.println("Application Submitted: " + application);

            model.addAttribute("success", true); // Add success message
            return "redirect:/viewJobs?success=true"; // Redirect to job listing with a success flag
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", true); // Add error message
            return "redirect:/applyJob/" + id + "?error=true"; // Redirect back to the form with an error flag
        }
    }

    // Mapping to track job application status
    @GetMapping("/viewApplications")
    public String viewAllApplications(Model model) {
        // Retrieve all applications from the repository
        List<JobApplication> applications = jobApplicationRepository.findAll();
        model.addAttribute("applications", applications); // Add the applications list to the model
        return "myApplications"; // This will display the application status (myApplications.html)
    }

    // Mapping to view specific application by ID
    @GetMapping("/viewApplications/{id}")
    public String trackApplication(@PathVariable Long id, Model model) {
        JobApplication application = jobApplicationRepository.findById(id).orElse(null);

        if (application != null) {
            model.addAttribute("application", application); // Pass the application details to the view
            return "myApplications"; // This will display the application status (myApplications.html)
        } else {
            model.addAttribute("error", true); // If application not found
            return "redirect:/viewJobs?error=true"; // Redirect back with error message
        }
    }

    // Optional: Mapping to display all jobs for which applications are being made
    @GetMapping("/viewJobApplication")
    public String viewJobs(Model model) {
        // Logic for fetching all jobs
        model.addAttribute("jobs", jobApplicationRepository.findAll()); // Assuming you have a job repository
        return "viewJobs"; // View to display all jobs
    }

    // Mapping to update the application status (e.g., Shortlisted, Rejected)
    @PostMapping("/updateApplicationStatus/{id}")
    public String updateApplicationStatus(@PathVariable Long id, @RequestParam String status, Model model) {
        try {
            JobApplication application = jobApplicationRepository.findById(id).orElse(null);

            if (application != null) {
                application.setStatus(status); // Update the status
                jobApplicationRepository.save(application); // Save the updated application

                model.addAttribute("success", true); // Add success message
                return "redirect:/trackApplication/" + id + "?success=true"; // Redirect to track the application with success flag
            } else {
                model.addAttribute("error", true); // Application not found
                return "redirect:/viewJobApplications?error=true"; // Redirect back with error
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", true); // Add error message
            return "redirect:/trackApplication/" + id + "?error=true"; // Redirect back with error flag
        }
    }
}
