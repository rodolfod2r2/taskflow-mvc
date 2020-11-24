package com.github.rodolfod2r2.mvc.taskflow.service;


import com.github.rodolfod2r2.mvc.taskflow.document.History;
import com.github.rodolfod2r2.mvc.taskflow.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryServiceImp implements GenericsInterfaceService<History> {

    @Autowired
    HistoryRepository historyRepository;

    @Override
    public Page<History> findAllPage(Pageable pageable) {
        return historyRepository.findAll(pageable);
    }

    @Override
    public List<History> findAll() {
        return historyRepository.findAll();
    }

    @Override
    public Optional<History> findById(String id) {
        return historyRepository.findById(id);
    }

    @Override
    public History save(History history) {
        return historyRepository.save(history);
    }
}
