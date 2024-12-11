package com.example.Samyak.placement_interaction_system;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profile {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 private Long id;
	 @Column(name = "first_name")
    private String firstName;
	 @Column(name = "middle_name")
    private String middleName;
	 @Column(name = "last_name")
    private String lastName;
    private int age;
    private String mobile;
    private String university;
    private String role; // Admin, Student, or Employee

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getFullName() {
        return firstName;
    }
    public void setFullName(String fullName) {
        this.firstName = fullName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
