package com.team200.codeconnectedserver.domain.job.controller;

import com.team200.codeconnectedserver.domain.job.model.Job;
import com.team200.codeconnectedserver.domain.job.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/job")
public class JobController {
    private JobService jobService;
    
    @Autowired
    public JobController(JobService jobService){
        this.jobService = jobService;
    }
    @GetMapping("/GetAll/")
    public ResponseEntity<List<Job>> getAll(){
        List<Job> job = jobService.getAll();
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> create(@RequestBody Job job){
        job = jobService.create(job);
        return new ResponseEntity<>(job, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Job> getById(@PathVariable("id") Long id){
        Job job = jobService.getById(id);
        return  new ResponseEntity<>(job, HttpStatus.OK);
    }

    @GetMapping("/GetJobTitle/")
    public  ResponseEntity<Job> getByJobTitle(@RequestParam String jobTitle){
        Job job = jobService.getByJobTitle(jobTitle);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Job> update(@PathVariable("id") Long id, @RequestBody Job jobDetail){
        jobDetail = jobService.update(id, jobDetail);
        return new ResponseEntity<>(jobDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        jobService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
