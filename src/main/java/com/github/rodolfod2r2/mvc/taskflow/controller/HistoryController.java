package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.History;
import com.github.rodolfod2r2.mvc.taskflow.service.HistoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class HistoryController {

    @Autowired
    HistoryServiceImp historyServiceImp;

    @GetMapping(value = "/history")
    public ResponseEntity<List<History>> getAllHistory() {
        List<History> listHistory = historyServiceImp.findAll();
        return new ResponseEntity<>(listHistory, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/history/{id}")
    public ResponseEntity<History> getHistoryById(@PathVariable String id) {
        Optional<History> history = historyServiceImp.findById(id);
        return history.map(history1 -> new ResponseEntity<>(history1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/history")
    public ResponseEntity<History> save(@RequestBody History history) {
        return new ResponseEntity<>(historyServiceImp.save(history), HttpStatus.CREATED);
    }

}
