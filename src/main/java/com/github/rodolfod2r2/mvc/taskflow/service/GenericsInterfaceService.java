package com.github.rodolfod2r2.mvc.taskflow.service;


import java.util.List;
import java.util.Optional;

public interface GenericsInterfaceService<T> {

    List<T> findAll();

    Optional<T> findById(String id);

    T save(T t);

}
