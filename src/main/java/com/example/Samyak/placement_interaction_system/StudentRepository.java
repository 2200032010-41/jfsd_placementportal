package com.example.Samyak.placement_interaction_system;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByNameAndPasswordAndRole(String name, String password, String role);

	
}
