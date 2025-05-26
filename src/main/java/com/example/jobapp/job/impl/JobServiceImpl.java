package com.example.jobapp.job.impl;

import com.example.jobapp.job.Job;
import com.example.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JobServiceImpl implements JobService {
    private Long nextId = 1L;
    final List<Job> jobs = new ArrayList<>();
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job : jobs) {
            if (Objects.equals(job.getId(), id)) {
                return job;
            }
        }
        return null;
    }


}
