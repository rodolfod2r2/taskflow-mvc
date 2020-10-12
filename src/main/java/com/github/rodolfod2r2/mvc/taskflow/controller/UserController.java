package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.User;
import com.github.rodolfod2r2.mvc.taskflow.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> listUser = userServiceImp.findAll();
        return new ResponseEntity<>(listUser, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userServiceImp.findById(id);
        return user.map(user1 -> new ResponseEntity<>(user1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(userServiceImp.save(user), HttpStatus.CREATED);
    }

}
