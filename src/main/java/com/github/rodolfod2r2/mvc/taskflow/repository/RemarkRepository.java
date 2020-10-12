package com.github.rodolfod2r2.mvc.taskflow.repository;


import com.github.rodolfod2r2.mvc.taskflow.document.Remark;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RemarkRepository extends MongoRepository<Remark, String> {
}
