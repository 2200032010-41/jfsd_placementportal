package com.example.Samyak.placement_interaction_system;

import com.example.Samyak.placement_interaction_system.Profile;
import com.example.Samyak.placement_interaction_system.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    // Get the profile from the database (using an ID or some other identifier if needed)
    private Profile getCurrentProfile() {
        // If the profile is saved in the session, you can retrieve it here.
        // Alternatively, fetch it from the repository using a unique identifier (e.g., user ID or session).
        return profileRepository.findById(1L).orElse(null); // Example using ID 1
    }

    @GetMapping
    public String viewProfile(Model model) {
        Profile currentProfile = getCurrentProfile();
        if (currentProfile != null) {
            model.addAttribute("profile", currentProfile);
            return "viewProfile";
        }
        return "redirect:/profile/create";
    }

    @GetMapping("/create")
    public String createProfileForm(Model model) {
        model.addAttribute("profile", new Profile());
        return "createProfile";
    }

    @PostMapping("/create")
    public String saveProfile(@ModelAttribute Profile profile) {
        profileRepository.save(profile); // Save the new profile directly
        return "redirect:/profile";
    }

    @GetMapping("/update")
    public String updateProfileForm(Model model) {
        Profile currentProfile = getCurrentProfile();
        if (currentProfile != null) {
            model.addAttribute("profile", currentProfile);
            return "updateProfile";
        }
        return "redirect:/profile/create";
    }

    @PostMapping("/update")
    public String updateProfile(@ModelAttribute Profile profile) {
        Profile currentProfile = getCurrentProfile();
        if (currentProfile != null) {
            // Simply copy values from the updated profile object
            currentProfile.setFullName(profile.getFullName());
            currentProfile.setMiddleName(profile.getMiddleName());
            currentProfile.setLastName(profile.getLastName());
            currentProfile.setAge(profile.getAge());
            currentProfile.setMobile(profile.getMobile());
            currentProfile.setUniversity(profile.getUniversity());
            currentProfile.setRole(profile.getRole());

            profileRepository.save(currentProfile); // Save the updated profile
        }
        return "redirect:/profile";
    }
}
