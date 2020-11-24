package com.github.rodolfod2r2.mvc.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(collection = "Team")
@Getter
@Setter
public class Team extends AbstractDocumentModel {

    private String name;
    private Archive archive;
    private Collection<User> userCollection;

}
