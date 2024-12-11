package com.example.Samyak.placement_interaction_system;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Samyak.placement_interaction_system.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    // No additional methods needed for now
}
