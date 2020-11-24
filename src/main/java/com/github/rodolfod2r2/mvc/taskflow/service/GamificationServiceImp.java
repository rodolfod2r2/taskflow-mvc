package com.github.rodolfod2r2.mvc.taskflow.service;

import com.github.rodolfod2r2.mvc.taskflow.document.Archive;
import com.github.rodolfod2r2.mvc.taskflow.document.Gamification;
import com.github.rodolfod2r2.mvc.taskflow.repository.GamificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamificationServiceImp implements GenericsInterfaceService<Gamification> {

    @Autowired
    GamificationRepository gamificationRepository;

    @Override
    public Page<Gamification> findAllPage(Pageable pageable){
        return gamificationRepository.findAll(pageable);
    }

    @Override
    public List<Gamification> findAll() {
        return gamificationRepository.findAll();
    }

    @Override
    public Optional<Gamification> findById(String id) {
        return gamificationRepository.findById(id);
    }

    @Override
    public Gamification save(Gamification gamification) {
        return gamificationRepository.save(gamification);
    }
}
