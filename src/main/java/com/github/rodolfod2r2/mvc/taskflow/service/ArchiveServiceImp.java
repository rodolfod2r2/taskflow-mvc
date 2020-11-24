package com.github.rodolfod2r2.mvc.taskflow.service;


import com.github.rodolfod2r2.mvc.taskflow.document.Archive;
import com.github.rodolfod2r2.mvc.taskflow.repository.ArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArchiveServiceImp implements GenericsInterfaceService<Archive> {

    @Autowired
    ArchiveRepository archiveRepository;

    @Override
    public Page<Archive> findAllPage (Pageable pageable){
        return archiveRepository.findAll(pageable);
    }

    @Override
    public List<Archive> findAll() {
        return archiveRepository.findAll();
    }

    @Override
    public Optional<Archive> findById(String id) {
        return archiveRepository.findById(id);
    }

    @Override
    public Archive save(Archive archive) {
        return archiveRepository.save(archive);
    }
}