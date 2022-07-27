package com.team200.codeconnectedserver.domain.education.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.team200.codeconnectedserver.domain.education.service.EducationService;
import com.team200.codeconnectedserver.domain.education.model.Education;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/education")
public class EducationController {
    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService){
        this.educationService = educationService;
    }

    @GetMapping("/GetAll/")
    public ResponseEntity<List<Education>> getAll(){
        List<Education> education = educationService.getAll();
        return new ResponseEntity<>(education, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Education> create(@RequestBody Education education){
        education = educationService.create(education);
        return new ResponseEntity<>(education, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") Long id){
        Education education = educationService.getById(id);
        return new ResponseEntity<>(education, HttpStatus.OK);
    }

    @GetMapping("/GetDegree/")
    public ResponseEntity<Education> getDegree(@RequestParam ("id") String degree){
        Education education = educationService.getByDegree(degree);
        return new ResponseEntity<>(education, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Education> update(@PathVariable("id") Long id, @RequestBody Education educationDetail){
        educationDetail = educationService.update(id, educationDetail);
        return new ResponseEntity<>(educationDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        educationService.delete(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
