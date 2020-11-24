package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Team;
import com.github.rodolfod2r2.mvc.taskflow.service.TeamServiceImp;
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
public class TeamController {

    @Autowired
    TeamServiceImp teamServiceImp;

    @GetMapping(value = "/team")
    public ResponseEntity<List<Team>> getAllTeam() {
        List<Team> listTeam = teamServiceImp.findAll();
        return new ResponseEntity<>(listTeam, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/team/pages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllTeamPages(
            @RequestParam(defaultValue = "0") int numberPage,
            @RequestParam(defaultValue = "3") int intervalPage
    ) {
        try {
            List<Team> elements;
            Pageable paging = PageRequest.of(numberPage, intervalPage);

            Page<Team> pages = teamServiceImp.findAllPage(paging);
            elements = pages.getContent();

            if (elements.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("team", elements);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/team/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable String id) {
        Optional<Team> team = teamServiceImp.findById(id);
        return team.map(team1 -> new ResponseEntity<>(team1, HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/team")
    public ResponseEntity<Team> save(@RequestBody Team team) {
        return new ResponseEntity<>(teamServiceImp.save(team), HttpStatus.CREATED);
    }

}
