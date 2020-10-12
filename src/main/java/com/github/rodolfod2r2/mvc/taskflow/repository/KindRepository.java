package com.github.rodolfod2r2.mvc.taskflow.repository;


import com.github.rodolfod2r2.mvc.taskflow.document.Kind;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KindRepository extends MongoRepository<Kind, String> {
}
