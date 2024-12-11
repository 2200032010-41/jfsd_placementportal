package com.example.Samyak.placement_interaction_system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

	public void applyForJob(Long jobId, JobApplication application) {
		// TODO Auto-generated method stub
		
	}
}
