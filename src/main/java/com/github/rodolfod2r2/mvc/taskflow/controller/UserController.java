package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.User;
import com.github.rodolfod2r2.mvc.taskflow.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @GetMapping(value = "/user/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllUserPages(
            @RequestParam(defaultValue = "0") int numberPage,
            @RequestParam(defaultValue = "3") int intervalPage
    ) {
        try {
            List<User> elements;
            Pageable paging = PageRequest.of(numberPage, intervalPage);

            Page<User> pages = userServiceImp.findAllPage(paging);
            elements = pages.getContent();

            if (elements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("user", elements);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
