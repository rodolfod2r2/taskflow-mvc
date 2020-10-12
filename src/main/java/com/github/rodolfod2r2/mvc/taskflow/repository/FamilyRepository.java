package com.github.rodolfod2r2.mvc.taskflow.repository;


import com.github.rodolfod2r2.mvc.taskflow.document.Family;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyRepository extends MongoRepository<Family, String> {
}
