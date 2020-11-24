package com.github.rodolfod2r2.mvc.taskflow.service;


import com.github.rodolfod2r2.mvc.taskflow.document.Family;
import com.github.rodolfod2r2.mvc.taskflow.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyServiceImp implements GenericsInterfaceService<Family> {

    @Autowired
    FamilyRepository familyRepository;

    @Override
    public Page<Family> findAllPage(Pageable pageable) {
        return familyRepository.findAll(pageable);
    }

    @Override
    public List<Family> findAll() {
        return familyRepository.findAll();
    }

    @Override
    public Optional<Family> findById(String id) {
        return familyRepository.findById(id);
    }

    @Override
    public Family save(Family family) {
        return familyRepository.save(family);
    }
}
