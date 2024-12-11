package com.example.Samyak.placement_interaction_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private JobService jobService;

    @Autowired
    private StudentRepository studentRepository;

    // Dashboard for the student
    @GetMapping("/studentDashboard")
    public String studentDashboard() {
        return "studentDashboard";
    }

    // View job opportunities
    @GetMapping("/viewJobs")
    public String viewJobOpportunities(Model model) {
        List<Job> jobs = jobService.getAllJobs();
        model.addAttribute("jobs", jobs);
        return "viewJobOpportunities";
    }

    // View student's applications
    @GetMapping("/viewMyApplications")
    public String viewMyApplications(Model model) {
        // Logic for viewing applications, add model attributes if needed
        return "myApplications";
    }

    // Review all applications (admin/placement officer)
    @GetMapping("/reviewApplications")
    public String reviewApplications(Model model) {
        // Logic for reviewing applications
        return "reviewApplications";
    }

    // Manage users (admin functionality)
    @GetMapping("/manageUsers")
    public String manageUsers(Model model, @RequestParam(value = "message", required = false) String message) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("studentList", students);

        // Display the success message if present
        if (message != null) {
            model.addAttribute("successMessage", message);
        }
        return "manageUsers";
    }

    // Mapping for editing a student
    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        // Fetch the student by ID and handle the case when not found
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));

        model.addAttribute("student", student);
        return "editUser"; // Returns editUser.html
    }

    // Mapping for updating a student's data
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle form errors, maybe redirect to the form page with error messages
            return "editUser";
        }

        // Save the updated student
        studentRepository.save(student);
        return "redirect:/manageUsers?message=Saved+Changes+Successfully";
    }

    // Mapping for deleting a student by ID (POST request)
    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        try {
            // Delete the student by ID
            studentRepository.deleteById(id);
            return "redirect:/manageUsers?message=Student+Deleted+Successfully";
        } catch (Exception e) {
            // Handle errors if student deletion fails
            model.addAttribute("errorMessage", "Failed to delete student.");
            return "manageUsers";
        }
    }

    // Optional: Handle error pages gracefully (you can create a generic error handler for the application)
    @ExceptionHandler(RuntimeException.class)
    public String handleError(RuntimeException ex, Model model) {
        model.addAttribute("errorMessage", "An error occurred: " + ex.getMessage());
        return "error"; // You should create an 'error.html' to handle error display
    }
}
