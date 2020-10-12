package com.github.rodolfod2r2.mvc.taskflow.repository;


import com.github.rodolfod2r2.mvc.taskflow.document.Archive;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArchiveRepository extends MongoRepository<Archive, String> {

}
