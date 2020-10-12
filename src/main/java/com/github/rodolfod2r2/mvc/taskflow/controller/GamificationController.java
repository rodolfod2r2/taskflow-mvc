package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Gamification;
import com.github.rodolfod2r2.mvc.taskflow.service.GamificationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class GamificationController {

    @Autowired
    GamificationServiceImp gamificationServiceImp;

    @GetMapping(value = "/gamification")
    public ResponseEntity<List<Gamification>> getAllGamification() {
        List<Gamification> listGamification = gamificationServiceImp.findAll();
        return new ResponseEntity<>(listGamification, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/gamification/{id}")
    public ResponseEntity<Gamification> getGamificationById(@PathVariable String id) {
        Optional<Gamification> gamification = gamificationServiceImp.findById(id);
        return gamification.map(gamification1 -> new ResponseEntity<>(gamification1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/gamification")
    public ResponseEntity<Gamification> save(@RequestBody Gamification gamification) {
        return new ResponseEntity<>(gamificationServiceImp.save(gamification), HttpStatus.CREATED);
    }

}
