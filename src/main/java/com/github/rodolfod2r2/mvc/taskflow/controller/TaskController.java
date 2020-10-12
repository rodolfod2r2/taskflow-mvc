package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Task;
import com.github.rodolfod2r2.mvc.taskflow.service.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class TaskController {

    @Autowired
    TaskServiceImp taskServiceImp;

    @GetMapping(value = "/task")
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> listTask = taskServiceImp.findAll();
        return new ResponseEntity<>(listTask, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        Optional<Task> task = taskServiceImp.findById(id);
        return task.map(task1 -> new ResponseEntity<>(task1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/task")
    public ResponseEntity<Task> save(@RequestBody Task user) {
        return new ResponseEntity<>(taskServiceImp.save(user), HttpStatus.CREATED);
    }

}
