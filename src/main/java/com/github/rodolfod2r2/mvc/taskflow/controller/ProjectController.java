package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Project;
import com.github.rodolfod2r2.mvc.taskflow.service.ProjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class ProjectController {

    @Autowired
    ProjectServiceImp projectServiceImp;

    @GetMapping(value = "/project")
    public ResponseEntity<List<Project>> getAllProject() {
        List<Project> listProject = projectServiceImp.findAll();
        return new ResponseEntity<>(listProject, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/project/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable String id) {
        Optional<Project> project = projectServiceImp.findById(id);
        return project.map(project1 -> new ResponseEntity<>(project1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/project")
    public ResponseEntity<Project> save(@RequestBody Project project) {
        return new ResponseEntity<>(projectServiceImp.save(project), HttpStatus.CREATED);
    }

}
