package com.github.rodolfod2r2.mvc.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
@Getter
@Setter
public class Team {

    @Id
    private String id;
    private String name;
    private Archive archive;
    private Collection<User> userCollection;

}
