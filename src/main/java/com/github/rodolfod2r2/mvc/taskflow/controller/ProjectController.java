package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Project;
import com.github.rodolfod2r2.mvc.taskflow.service.ProjectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @GetMapping(value = "/project/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllProjectPages(
            @RequestParam(defaultValue = "0") int numberPage,
            @RequestParam(defaultValue = "3") int intervalPage
    ) {
        try {
            List<Project> elements;
            Pageable paging = PageRequest.of(numberPage, intervalPage);

            Page<Project> pages = projectServiceImp.findAllPage(paging);
            elements = pages.getContent();

            if (elements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("project", elements);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
