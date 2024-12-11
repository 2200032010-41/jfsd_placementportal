package com.example.Samyak.placement_interaction_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String handleLoginForm(@Valid @ModelAttribute LoginForm loginForm, BindingResult result, Model model) {
        String name = loginForm.getName();
        String password = loginForm.getPassword();
        String role = loginForm.getRole();

        // Check password length (at least 9 characters)
        if (password.length() < 9) {
            model.addAttribute("errorMessage", "Password must be at least 9 characters.");
            return "login";
        }

        // Process login based on role and credentials
        boolean loginSuccess = processLogin(name, password, role);

        if (loginSuccess) {
            // Redirect based on the role of the user
            switch (role.toLowerCase()) {
                case "student":
                    return "redirect:/studentDashboard";  // Redirect to student dashboard
                case "admin":
                    return "redirect:/admin";    // Redirect to admin dashboard
                case "employee":
                    return "redirect:/employerDashboard"; // Redirect to employee dashboard
                default:
                    model.addAttribute("errorMessage", "Invalid role.");
                    return "login";
            }
        } else {
            model.addAttribute("errorMessage", "Incorrect username, password, or role.");
            return "login";
        }
    }

    private boolean processLogin(String name, String password, String role) {
        // Check for user by role, name, and password
        return studentRepository.findByNameAndPasswordAndRole(name, password, role).isPresent();
    }
}
