package com.github.rodolfod2r2.mvc.taskflow.service;


import com.github.rodolfod2r2.mvc.taskflow.document.Remark;
import com.github.rodolfod2r2.mvc.taskflow.repository.RemarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemarkServiceImp implements GenericsInterfaceService<Remark> {

    @Autowired
    RemarkRepository remarkRepository;


    @Override
    public List<Remark> findAll() {
        return remarkRepository.findAll();
    }

    @Override
    public Optional<Remark> findById(String id) {
        return remarkRepository.findById(id);
    }

    @Override
    public Remark save(Remark remark) {
        return remarkRepository.save(remark);
    }
}
