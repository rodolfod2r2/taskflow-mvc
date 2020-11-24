package com.github.rodolfod2r2.mvc.taskflow.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GenericsInterfaceService<T> {

    Page<T> findAllPage (Pageable pageable);

    List<T> findAll();

    Optional<T> findById(String id);

    T save(T t);

}
