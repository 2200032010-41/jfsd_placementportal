package com.example.Samyak.placement_interaction_system;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary Key

    @Column(name = "job_id")  // This maps the 'jobId' field to 'job_id' in the database
    private Long jobId;

    @Column(name = "user_id")  // This maps the 'userId' field to 'user_id' in the database
    private Long userId;  // Link to the user applying for the job

    @Column(name = "job_title")  // Mapping for job title
    private String jobTitle;

    @Column(name = "name")  // Applicant's name
    private String name;

    @Column(name = "email")  // Applicant's email
    private String email;

    @Column(name = "phone")  // Applicant's phone number
    private String phone;

    @Column(name = "address")  // Applicant's address
    private String address;

    @Column(name = "experience")  // Applicant's experience in years
    private Integer experience;

    @Column(name = "skills")  // Applicant's skills
    private String skills;

    @Column(name = "application_date")  // Date of application submission
    private LocalDate applicationDate;

    @Column(name = "status")  // Status of the application (e.g., Processing, Shortlisted, Rejected)
    private String status;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "id=" + id +
                ", jobId=" + jobId +
                ", userId=" + userId +
                ", jobTitle='" + jobTitle + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", experience=" + experience +
                ", skills='" + skills + '\'' +
                ", applicationDate=" + applicationDate +
                ", status='" + status + '\'' +
                '}';
    }
}
