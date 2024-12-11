package com.example.Samyak.placement_interaction_system;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "students") // Optional: specify table name
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generated ID
    private Long id;

    @NotBlank(message = "Name is required") // Updated validation message for clarity
    private String name;

    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

    @NotBlank(message = "Email is required") // Updated validation message for clarity
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is required") // Updated validation message for clarity
    private String password;

    private String role; // Role (e.g., student, admin, employee)

    // Default constructor is required by JPA
    public Student() {
    }

    public Student(String name, int age, String email, String password, String role) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password; // Include setter for password
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role; // Accept the role parameter
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' + // Include role in the string representation
                '}';
    }
}
