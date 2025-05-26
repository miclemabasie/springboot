package com.example.jobapp.job.impl;

import com.example.jobapp.job.Job;
import com.example.jobapp.job.JobRepository;
import com.example.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    // final List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);

    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);

            if(jobOptional.isPresent()){
                // update the job
                Job updatedJob = jobOptional.get();
                updatedJob.setTitle(job.getTitle());
                updatedJob.setDescription(job.getDescription());
                updatedJob.setMinSalary(job.getMinSalary());
                updatedJob.setMaxSalary(job.getMaxSalary());
                updatedJob.setLocation(job.getLocation());
                jobRepository.save(updatedJob);
                return true;
            }

        return false;
    }


}
