package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Archive;
import com.github.rodolfod2r2.mvc.taskflow.response.CustomResponse;
import com.github.rodolfod2r2.mvc.taskflow.service.ArchiveServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class ArchiveController {

    @Autowired
    ArchiveServiceImp archiveServiceImp;

    @Operation(summary = "get Test Archive")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Archive"),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied"),
            @ApiResponse(responseCode = "404", description = "Archive not found")
    })
    @GetMapping(value = "/test")
    public CustomResponse<Archive> getTest() {
        Archive archive = new Archive();
        archive.setId("1");
        archive.setName("toper");
        archive.setPath("tuupla");
        return new CustomResponse<>(HttpStatus.OK.value(), "success", null, archive);
    }


    @GetMapping(value = "/test2")
    public ResponseEntity<?> getTest2() {
        return new ResponseEntity<>(new CustomResponse<>(HttpStatus.OK.value(), "success", null, null), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/archive", consumes = MediaType.APPLICATION_JSON_VALUE)
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
