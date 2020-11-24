package com.github.rodolfod2r2.mvc.taskflow.service;


import com.github.rodolfod2r2.mvc.taskflow.document.Halo;
import com.github.rodolfod2r2.mvc.taskflow.repository.HaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HaloServiceImp implements GenericsInterfaceService<Halo> {

    @Autowired
    HaloRepository haloRepository;

    @Override
    public Page<Halo> findAllPage(Pageable pageable) {
        return haloRepository.findAll(pageable);
    }

    @Override
    public List<Halo> findAll() {
        return haloRepository.findAll();
    }

    @Override
    public Optional<Halo> findById(String id) {
        return haloRepository.findById(id);
    }

    @Override
    public Halo save(Halo halo) {
        return haloRepository.save(halo);
    }
}
