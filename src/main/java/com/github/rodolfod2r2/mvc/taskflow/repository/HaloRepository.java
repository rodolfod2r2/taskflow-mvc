package com.github.rodolfod2r2.mvc.taskflow.repository;


import com.github.rodolfod2r2.mvc.taskflow.document.Halo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HaloRepository extends MongoRepository<Halo, String> {
}
