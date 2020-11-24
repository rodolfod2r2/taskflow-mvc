package com.github.rodolfod2r2.mvc.taskflow.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Gamification")
@Getter
@Setter
public class Gamification extends AbstractDocumentModel {

    private String name;
    private String description;
    private int points;
    private Archive archive;

}
