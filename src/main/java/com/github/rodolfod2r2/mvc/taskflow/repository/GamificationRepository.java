package com.github.rodolfod2r2.mvc.taskflow.repository;


import com.github.rodolfod2r2.mvc.taskflow.document.Gamification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GamificationRepository extends MongoRepository<Gamification, String> {

}
