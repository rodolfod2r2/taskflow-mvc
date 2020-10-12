package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Halo;
import com.github.rodolfod2r2.mvc.taskflow.service.HaloServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class HaloController {

    @Autowired
    HaloServiceImp haloServiceImp;

    @GetMapping(value = "/halo")
    public ResponseEntity<List<Halo>> getAllHalo() {
        List<Halo> listHalo = haloServiceImp.findAll();
        return new ResponseEntity<>(listHalo, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/halo/{id}")
    public ResponseEntity<Halo> getHaloById(@PathVariable String id) {
        Optional<Halo> halo = haloServiceImp.findById(id);
        return halo.map(halo1 -> new ResponseEntity<>(halo1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/halo")
    public ResponseEntity<Halo> save(@RequestBody Halo halo) {
        return new ResponseEntity<>(haloServiceImp.save(halo), HttpStatus.CREATED);
    }

}
