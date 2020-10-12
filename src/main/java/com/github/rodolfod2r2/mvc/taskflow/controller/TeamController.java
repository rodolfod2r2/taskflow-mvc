package com.github.rodolfod2r2.mvc.taskflow.controller;


import com.github.rodolfod2r2.mvc.taskflow.document.Team;
import com.github.rodolfod2r2.mvc.taskflow.service.TeamServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
