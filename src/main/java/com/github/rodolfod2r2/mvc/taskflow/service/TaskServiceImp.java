package com.github.rodolfod2r2.mvc.taskflow.service;


import com.github.rodolfod2r2.mvc.taskflow.document.Task;
import com.github.rodolfod2r2.mvc.taskflow.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements GenericsInterfaceService<Task> {

    @Autowired
    TaskRepository taskRepository;


    @Override
    public Page<Task> findAllPage(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
