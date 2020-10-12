package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Skill;
import com.github.rodolfod2r2.mvc.taskflow.service.SkillServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
