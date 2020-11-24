package com.github.rodolfod2r2.mvc.taskflow.service;


import com.github.rodolfod2r2.mvc.taskflow.document.Skill;
import com.github.rodolfod2r2.mvc.taskflow.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImp implements GenericsInterfaceService<Skill> {

    @Autowired
    SkillRepository skillRepository;


    @Override
    public Page<Skill> findAllPage(Pageable pageable) {
        return skillRepository.findAll(pageable);
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Optional<Skill> findById(String id) {
        return skillRepository.findById(id);
    }

    @Override
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }
}
