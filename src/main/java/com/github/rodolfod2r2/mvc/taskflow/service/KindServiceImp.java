package com.github.rodolfod2r2.mvc.taskflow.service;


import com.github.rodolfod2r2.mvc.taskflow.document.Kind;
import com.github.rodolfod2r2.mvc.taskflow.repository.KindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KindServiceImp implements GenericsInterfaceService<Kind> {

    @Autowired
    KindRepository kindRepository;


    @Override
    public List<Kind> findAll() {
        return kindRepository.findAll();
    }

    @Override
    public Optional<Kind> findById(String id) {
        return kindRepository.findById(id);
    }

    @Override
    public Kind save(Kind kind) {
        return kindRepository.save(kind);
    }
}
