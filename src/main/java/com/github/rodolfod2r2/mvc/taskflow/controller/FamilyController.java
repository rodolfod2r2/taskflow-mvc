package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Family;
import com.github.rodolfod2r2.mvc.taskflow.service.FamilyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class FamilyController {

    @Autowired
    FamilyServiceImp familyServiceImp;

    @GetMapping(value = "/family")
    public ResponseEntity<List<Family>> getAllFamily() {
        List<Family> listFamily = familyServiceImp.findAll();
        return new ResponseEntity<>(listFamily, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/family/{id}")
    public ResponseEntity<Family> getFamilyById(@PathVariable String id) {
        Optional<Family> family = familyServiceImp.findById(id);
        return family.map(family1 -> new ResponseEntity<>(family1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/family")
    public ResponseEntity<Family> save(@RequestBody Family family) {
        return new ResponseEntity<>(familyServiceImp.save(family), HttpStatus.CREATED);
    }

}
