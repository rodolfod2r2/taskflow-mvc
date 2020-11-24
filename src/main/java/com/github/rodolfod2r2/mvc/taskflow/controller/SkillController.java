package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Skill;
import com.github.rodolfod2r2.mvc.taskflow.service.SkillServiceImp;
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
public class SkillController {

    @Autowired
    SkillServiceImp skillServiceImp;

    @GetMapping(value = "/skill")
    public ResponseEntity<List<Skill>> getAllSkill() {
        List<Skill> listTask = skillServiceImp.findAll();
        return new ResponseEntity<>(listTask, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/skill/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllSkillPages(
            @RequestParam(defaultValue = "0") int numberPage,
            @RequestParam(defaultValue = "3") int intervalPage
    ) {
        try {
            List<Skill> elements;
            Pageable paging = PageRequest.of(numberPage, intervalPage);

            Page<Skill> pages = skillServiceImp.findAllPage(paging);
            elements = pages.getContent();

            if (elements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("skill", elements);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/skill/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable String id) {
        Optional<Skill> task = skillServiceImp.findById(id);
        return task.map(task1 -> new ResponseEntity<>(task1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/skill")
    public ResponseEntity<Skill> save(@RequestBody Skill user) {
        return new ResponseEntity<>(skillServiceImp.save(user), HttpStatus.CREATED);
    }

}
