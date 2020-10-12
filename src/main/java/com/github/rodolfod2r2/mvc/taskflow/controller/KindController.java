package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Kind;
import com.github.rodolfod2r2.mvc.taskflow.service.KindServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class KindController {

    @Autowired
    KindServiceImp kindServiceImp;

    @GetMapping(value = "/kind")
    public ResponseEntity<List<Kind>> getAllKind() {
        List<Kind> listKind = kindServiceImp.findAll();
        return new ResponseEntity<>(listKind, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/kind/{id}")
    public ResponseEntity<Kind> getKindById(@PathVariable String id) {
        Optional<Kind> kind = kindServiceImp.findById(id);
        return kind.map(kind1 -> new ResponseEntity<>(kind1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/kind")
    public ResponseEntity<Kind> save(@RequestBody Kind kind) {
        return new ResponseEntity<>(kindServiceImp.save(kind), HttpStatus.CREATED);
    }

}
