package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Archive;
import com.github.rodolfod2r2.mvc.taskflow.service.ArchiveServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class ArchiveController {

    @Autowired
    ArchiveServiceImp archiveServiceImp;

    @GetMapping(value = "/archive")
    public ResponseEntity<List<Archive>> getAllArchive() {
        List<Archive> listArchive = archiveServiceImp.findAll();
        return new ResponseEntity<>(listArchive, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/archive/{id}")
    public ResponseEntity<Archive> getArchiveById(@PathVariable String id) {
        Optional<Archive> archive = archiveServiceImp.findById(id);
        return archive.map(archive1 -> new ResponseEntity<>(archive1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/archive")
    public ResponseEntity<Archive> save(@RequestBody Archive archive) {
        return new ResponseEntity<>(archiveServiceImp.save(archive), HttpStatus.CREATED);
    }

}
