package com.github.rodolfod2r2.mvc.taskflow.service;

import com.github.rodolfod2r2.mvc.taskflow.document.Project;
import com.github.rodolfod2r2.mvc.taskflow.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImp implements GenericsInterfaceService<Project> {

    @Autowired
    ProjectRepository projectRepository;


    @Override
    public Page<Project> findAllPage(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(String id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
}
