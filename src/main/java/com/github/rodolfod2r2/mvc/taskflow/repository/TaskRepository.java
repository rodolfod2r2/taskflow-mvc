package com.github.rodolfod2r2.mvc.taskflow.repository;


import com.github.rodolfod2r2.mvc.taskflow.document.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
