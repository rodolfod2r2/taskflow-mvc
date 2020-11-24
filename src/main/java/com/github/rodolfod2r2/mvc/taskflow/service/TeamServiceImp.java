package com.github.rodolfod2r2.mvc.taskflow.service;

import com.github.rodolfod2r2.mvc.taskflow.document.Team;
import com.github.rodolfod2r2.mvc.taskflow.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImp implements GenericsInterfaceService<Team> {

    @Autowired
    TeamRepository teamRepository;

    @Override
    public Page<Team> findAllPage(Pageable pageable) {
        return teamRepository.findAll(pageable);
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> findById(String id) {
        return teamRepository.findById(id);
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }
}
