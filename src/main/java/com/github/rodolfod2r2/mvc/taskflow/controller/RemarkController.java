package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Remark;
import com.github.rodolfod2r2.mvc.taskflow.service.RemarkServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class RemarkController {

    @Autowired
    RemarkServiceImp remarkServiceImp;

    @GetMapping(value = "/remark")
    public ResponseEntity<List<Remark>> getAllRemark() {
        List<Remark> listRemark = remarkServiceImp.findAll();
        return new ResponseEntity<>(listRemark, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/remark/{id}")
    public ResponseEntity<Remark> getRemarkById(@PathVariable String id) {
        Optional<Remark> remark = remarkServiceImp.findById(id);
        return remark.map(remark1 -> new ResponseEntity<>(remark1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/remark")
    public ResponseEntity<Remark> save(@RequestBody Remark user) {
        return new ResponseEntity<>(remarkServiceImp.save(user), HttpStatus.CREATED);
    }

}
