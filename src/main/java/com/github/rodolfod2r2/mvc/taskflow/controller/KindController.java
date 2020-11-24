package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Kind;
import com.github.rodolfod2r2.mvc.taskflow.service.KindServiceImp;
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
public class KindController {

    @Autowired
    KindServiceImp kindServiceImp;

    @GetMapping(value = "/kind")
    public ResponseEntity<List<Kind>> getAllKind() {
        List<Kind> listKind = kindServiceImp.findAll();
        return new ResponseEntity<>(listKind, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/kind/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllKindPages(
            @RequestParam(defaultValue = "0") int numberPage,
            @RequestParam(defaultValue = "3") int intervalPage
    ) {
        try {
            List<Kind> elements;
            Pageable paging = PageRequest.of(numberPage, intervalPage);

            Page<Kind> pages = kindServiceImp.findAllPage(paging);
            elements = pages.getContent();

            if (elements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("kind", elements);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
